package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.OrdenCompra;
import com.backend.nike.backend_nike_website.entities.Producto;
import com.backend.nike.backend_nike_website.repositories.OrdenCompraRepository;
import com.backend.nike.backend_nike_website.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenCompraServiceImpl extends BaseServiceImpl<OrdenCompra, Integer> implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ProductoRepository productoRepository;

    public OrdenCompraServiceImpl(OrdenCompraRepository ordenCompraRepository,
                                  ProductoRepository productoRepository) {
        super(ordenCompraRepository);
        this.ordenCompraRepository = ordenCompraRepository;
        this.productoRepository = productoRepository;
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
        OrdenCompra orden = new OrdenCompra();

        List<Producto> productos = new ArrayList<>();

        for (Long id : ids) {
            Producto producto = productoRepository.findById(Math.toIntExact(id))
                    .orElseThrow(() -> new Exception("Producto no encontrado con ID: " + id));
            productos.add(producto);
        }

        orden.setProductos(productos);
        orden.setEstado("PENDIENTE");
        orden.setFechaCompra(LocalDate.from(LocalDateTime.now()));

        OrdenCompra ordenGuardada = this.save(orden);

        return ordenGuardada;
    }


}
