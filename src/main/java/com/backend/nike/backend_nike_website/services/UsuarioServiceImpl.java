package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.Usuario;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public UsuarioServiceImpl(BaseRepository<Usuario, Integer> baseRepository) {
        super(baseRepository);
    }
    
} 