package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.ItemOrden;
import com.backend.nike.backend_nike_website.entities.OrdenCompra;
import com.backend.nike.backend_nike_website.repositories.OrdenCompraRepository;
import com.backend.nike.backend_nike_website.repositories.ProductoRepository;
import com.backend.nike.backend_nike_website.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraServiceImpl extends BaseServiceImpl<OrdenCompra, Integer> implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    public OrdenCompraServiceImpl(OrdenCompraRepository ordenCompraRepository,
            ProductoRepository productoRepository,
            UsuarioRepository usuarioRepository) {
        super(ordenCompraRepository);
        this.ordenCompraRepository = ordenCompraRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public OrdenCompra save(OrdenCompra orden) throws Exception {
        if (orden.getUsuario() != null && orden.getUsuario().getId() != null) {
            var usuarioCompleto = usuarioRepository.findById(orden.getUsuario().getId())
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));
            orden.setUsuario(usuarioCompleto);
        }

        if (orden.getItems() != null) {
            for (ItemOrden item : orden.getItems()) {
                item.setOrdenCompra(orden);

                var productoReal = productoRepository.findById(item.getProducto().getId())
                        .orElseThrow(() -> new Exception("Producto no encontrado"));
                item.setProducto(productoReal);
            }
        }

        return super.save(orden);
    }

}
