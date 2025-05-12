package com.backend.nike.backend_nike_website.service;

import com.backend.nike.backend_nike_website.entity.Talle;

import java.util.List;
import java.util.Optional;

public interface TalleService {
    List<Talle> listar();
    Talle guardar(Talle talle);
    Optional<Talle> obtenerPorId(Long id);
    void eliminar(Long id);
}
