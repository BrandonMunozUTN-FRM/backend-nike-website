package com.backend.nike.backend_nike_website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.nike.backend_nike_website.entities.Talle;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.TalleRepository;

@Service
public class TalleServiceImp extends BaseServiceImpl<Talle, Integer> implements TalleService {

    @Autowired
    private TalleRepository talleRepository;

    public TalleServiceImp(BaseRepository<Talle, Integer> baseRepository) {
        super(baseRepository);
    }

// Si querés métodos personalizados, los implementás acá
}
