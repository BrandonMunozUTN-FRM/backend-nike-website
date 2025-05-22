package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Detalle;
import com.backend.nike.backend_nike_website.services.DetalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/detalles")
public class DetalleController extends BaseController<Detalle, Integer> {

    @Autowired
    private DetalleServiceImpl detalleServiceImpl;

    public DetalleController(DetalleServiceImpl detalleServiceImpl) {
        super(detalleServiceImpl);
    }

}
