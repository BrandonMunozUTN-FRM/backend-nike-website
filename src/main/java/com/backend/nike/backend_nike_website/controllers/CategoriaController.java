package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Categoria;
import com.backend.nike.backend_nike_website.services.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/categorias")
public class CategoriaController extends BaseController<Categoria, Integer> {

    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    public CategoriaController(CategoriaServiceImpl categoriaServiceImpl) {
        super(categoriaServiceImpl);
    }

}
