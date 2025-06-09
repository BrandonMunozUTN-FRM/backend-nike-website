package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Categoria;
import com.backend.nike.backend_nike_website.services.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/categorias")
public class CategoriaController extends BaseController<Categoria, Integer> {

    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    // Constructor que pasa el servicio al controlador base
    public CategoriaController(CategoriaServiceImpl categoriaServiceImpl) {
        super(categoriaServiceImpl);
    }

}
