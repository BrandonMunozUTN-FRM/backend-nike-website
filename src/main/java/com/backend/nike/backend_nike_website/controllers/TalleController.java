package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Talle;
import com.backend.nike.backend_nike_website.services.TalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/talles")
// Controlador para manejar las operaciones de Talle
public class TalleController extends BaseController<Talle, Integer> {

    @Autowired
    private TalleServiceImpl talleServiceImpl;

    // Constructor que pasa el servicio al controlador base
    public TalleController(TalleServiceImpl talleServiceImpl) {
        super(talleServiceImpl);
    }
}
