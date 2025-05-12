package com.backend.nike.backend_nike_website.service.impl;

import com.backend.nike.backend_nike_website.entity.Genero;
import com.backend.nike.backend_nike_website.repository.GeneroRepository;
import com.backend.nike.backend_nike_website.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> listar() {
        return generoRepository.findAll();
    }

    @Override
    public Genero guardar(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Optional<Genero> obtenerPorId(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        generoRepository.deleteById(id);
    }
}
