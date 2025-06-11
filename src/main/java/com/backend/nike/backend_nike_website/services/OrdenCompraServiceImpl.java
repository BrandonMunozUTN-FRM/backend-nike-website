package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.OrdenCompra;
import com.backend.nike.backend_nike_website.entities.Producto;
import com.backend.nike.backend_nike_website.entities.Usuario;
import com.backend.nike.backend_nike_website.jwt.JwtAuthenticationFilter;
import com.backend.nike.backend_nike_website.repositories.OrdenCompraRepository;
import com.backend.nike.backend_nike_website.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.backend.nike.backend_nike_website.repositories.UsuarioRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrdenCompraServiceImpl extends BaseServiceImpl<OrdenCompra, Integer> implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;


    public OrdenCompraServiceImpl(OrdenCompraRepository ordenCompraRepository,
                                  ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {
        super(ordenCompraRepository);
        this.ordenCompraRepository = ordenCompraRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public OrdenCompra save(OrdenCompra orden) throws Exception {
        double total = 0.0;

        if (orden.getProductos() != null) {
            for (var producto : orden.getProductos()) {
                var productoReal = productoRepository.findById(producto.getId())
                        .orElseThrow(() -> new Exception("Producto no encontrado"));
                producto.setNombre(productoReal.getNombre());
                producto.setPrecio(productoReal.getPrecio());
                total += productoReal.getPrecio();
            }
        }

        orden.setTotal(total);

        return super.save(orden);
    }


    @Override
    @Transactional
    public OrdenCompra generarOrdenCompra(List<Long> ids) throws Exception {

        String username = ((UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUsername();

        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        OrdenCompra orden = new OrdenCompra();
        orden.setEstado("PENDIENTE");
        orden.setFechaCompra(LocalDate.now());
        orden.setUsuario(usuario); // 🟢 Asignar el usuario a la orden

        List<Producto> productosFinales = new ArrayList<>();
        double total = 0.0;

        var cantidadPorProducto = new java.util.HashMap<Long, Integer>();
        for (Long id : ids) {
            cantidadPorProducto.put(id, cantidadPorProducto.getOrDefault(id, 0) + 1);
        }

        for (var entry : cantidadPorProducto.entrySet()) {
            Long productoId = entry.getKey();
            Integer cantidad = entry.getValue();

            Producto producto = productoRepository.findById(Math.toIntExact(productoId))
                    .orElseThrow(() -> new Exception("Producto no encontrado con ID: " + productoId));

            if (producto.getStock() == null || producto.getStock() < cantidad) {
                throw new Exception("Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - cantidad);
            productoRepository.save(producto);

            for (int i = 0; i < cantidad; i++) {
                productosFinales.add(producto);
            }

            total += producto.getPrecio() * cantidad;
        }

        orden.setProductos(productosFinales);
        orden.setTotal(total);

        return super.save(orden);
    }

    @Override
    public Optional<OrdenCompra> findByPreferenceId(String preferenceId) {
        return ordenCompraRepository.findByPreferenceId(preferenceId);
    }
}

