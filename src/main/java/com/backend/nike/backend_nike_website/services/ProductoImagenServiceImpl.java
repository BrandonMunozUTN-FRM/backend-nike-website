package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.ProductoImagen;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.ProductoImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoImagenServiceImpl extends BaseServiceImpl<ProductoImagen, Integer> {
    
    @Autowired
    private ProductoImagenRepository productoImagenRepository;
    
    public ProductoImagenServiceImpl(BaseRepository<ProductoImagen, Integer> baseRepository) {
        super(baseRepository);
    }
    
} 