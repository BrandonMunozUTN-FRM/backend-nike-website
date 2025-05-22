package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.CompraOden;
import com.backend.nike.backend_nike_website.services.CompraOdenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/compra-orden")
public class CompraOdenController extends BaseController<CompraOden, Integer> {

    @Autowired
    private CompraOdenServiceImpl compraOdenServiceImpl;

    public CompraOdenController(CompraOdenServiceImpl compraOdenServiceImpl) {
        super(compraOdenServiceImpl);
    }
}
