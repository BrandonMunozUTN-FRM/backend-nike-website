package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.Direccion;
import com.backend.nike.backend_nike_website.repositories.DireccionRepository;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion, Integer> {
    
    @Autowired
    private DireccionRepository adressRepository;
    
    public DireccionServiceImpl(BaseRepository<Direccion, Integer> baseRepository) {
        super(baseRepository);
    }
    
    
} 