package com.backend.nike.backend_nike_website.service.impl;

import com.backend.nike.backend_nike_website.entity.Talle;
import com.backend.nike.backend_nike_website.repository.TalleRepository;
import com.backend.nike.backend_nike_website.service.TalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalleServiceImpl implements TalleService {

    @Autowired
    private TalleRepository talleRepository;

    @Override
    public List<Talle> listar() {
        return talleRepository.findAll();
    }

    @Override
    public Talle guardar(Talle talle) {
        return talleRepository.save(talle);
    }

    @Override
    public Optional<Talle> obtenerPorId(Long id) {
        return talleRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        talleRepository.deleteById(id);
    }
}
