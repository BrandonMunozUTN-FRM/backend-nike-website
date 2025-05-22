package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.Detalle;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends BaseServiceImpl<Detalle, Integer> {
    
    @Autowired
    private DetalleRepository detalleRepository;
    
    public DetalleServiceImpl(BaseRepository<Detalle, Integer> baseRepository) {
        super(baseRepository);
    }
} 