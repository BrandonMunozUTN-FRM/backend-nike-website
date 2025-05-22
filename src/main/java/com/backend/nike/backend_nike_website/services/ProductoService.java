package com.backend.nike.backend_nike_website.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.backend.nike.backend_nike_website.entities.Producto;

public interface ProductoService extends BaseService<Producto, Integer> {
    Page<Producto> search(String filtro, Pageable pageable) throws Exception;
}
