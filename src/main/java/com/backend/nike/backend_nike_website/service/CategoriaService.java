package com.backend.nike.backend_nike_website.service;

import com.backend.nike.backend_nike_website.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> listar();
    Categoria guardar(Categoria categoria);
    Optional<Categoria> obtenerPorId(Long id);
    void eliminar(Long id);
}
