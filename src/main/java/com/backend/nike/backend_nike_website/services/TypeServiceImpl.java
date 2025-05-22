package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.Type;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends BaseServiceImpl<Type, Integer> {
    
    @Autowired
    private TypeRepository typeRepository;
    
    public TypeServiceImpl(BaseRepository<Type, Integer> baseRepository) {
        super(baseRepository);
    }
} 