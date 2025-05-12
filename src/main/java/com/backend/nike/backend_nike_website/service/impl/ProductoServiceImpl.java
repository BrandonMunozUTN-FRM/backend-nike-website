package com.backend.nike.backend_nike_website.service.impl;

import com.backend.nike.backend_nike_website.entity.Producto;
import com.backend.nike.backend_nike_website.repository.ProductoRepository;
import com.backend.nike.backend_nike_website.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
