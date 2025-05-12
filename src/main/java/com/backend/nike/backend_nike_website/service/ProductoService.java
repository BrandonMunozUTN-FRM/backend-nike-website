package com.backend.nike.backend_nike_website.service;

import com.backend.nike.backend_nike_website.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Producto guardar(Producto producto);
    Optional<Producto> obtenerPorId(Long id);
    void eliminar(Long id);
}
