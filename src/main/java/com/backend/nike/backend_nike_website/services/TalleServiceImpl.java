package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.Talle;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.TalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalleServiceImpl extends BaseServiceImpl<Talle, Integer> {
    
    @Autowired
    private TalleRepository talleRepository;
    
    public TalleServiceImpl(BaseRepository<Talle, Integer> baseRepository) {
        super(baseRepository);
    }
    
}