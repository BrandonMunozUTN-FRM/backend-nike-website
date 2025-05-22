package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.Descuento;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescuentoServiceImpl extends BaseServiceImpl<Descuento, Integer> {
    
    @Autowired
    private DescuentoRepository descuentoRepository;
    
    public DescuentoServiceImpl(BaseRepository<Descuento, Integer> baseRepository) {
        super(baseRepository);
    }
}