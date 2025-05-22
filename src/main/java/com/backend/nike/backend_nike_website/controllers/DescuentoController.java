package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Descuento;
import com.backend.nike.backend_nike_website.services.DescuentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/descuentos")
public class DescuentoController extends BaseController<Descuento, Integer> {

    @Autowired
    private DescuentoServiceImpl descuentoServiceImpl;

    public DescuentoController(DescuentoServiceImpl descuentoServiceImpl) {
        super(descuentoServiceImpl);
    }

}
