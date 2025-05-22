package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.ProductoImagen;
import com.backend.nike.backend_nike_website.services.ProductoImagenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/producto-imagennes")
public class ProductoImagenController extends BaseController<ProductoImagen, Integer> {

    @Autowired
    private ProductoImagenServiceImpl productoImagenServiceImpl;

    // Constructor que pasa el service al controlador base
    public ProductoImagenController(ProductoImagenServiceImpl productoImagenServiceImpl) {
        super(productoImagenServiceImpl);
    }
}
