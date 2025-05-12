package com.backend.nike.backend_nike_website.service;

import com.backend.nike.backend_nike_website.entity.Genero;

import java.util.List;
import java.util.Optional;

public interface GeneroService {
    List<Genero> listar();
    Genero guardar(Genero genero);
    Optional<Genero> obtenerPorId(Long id);
    void eliminar(Long id);
}
