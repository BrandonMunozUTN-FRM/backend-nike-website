package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Direccion;
import com.backend.nike.backend_nike_website.services.DireccionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/direcciones")
public class DireccionController extends BaseController<Direccion, Integer> {

    @Autowired
    private DireccionServiceImpl adressServiceImpl;

    public DireccionController(DireccionServiceImpl adressServiceImpl) {
        super(adressServiceImpl);
    }
}
