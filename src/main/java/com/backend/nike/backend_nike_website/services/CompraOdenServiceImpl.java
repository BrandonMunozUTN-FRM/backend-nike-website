package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.CompraOden;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.CompraOdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraOdenServiceImpl extends BaseServiceImpl<CompraOden, Integer> {
    
    @Autowired
    private CompraOdenRepository compraOdenRepository;
    
    public CompraOdenServiceImpl(BaseRepository<CompraOden, Integer> baseRepository) {
        super(baseRepository);
    }
    
    
} 