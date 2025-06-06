package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.OrdenCompra;
import com.backend.nike.backend_nike_website.services.OrdenCompraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/ordenes")
public class OrdenCompraController extends BaseController<OrdenCompra, Integer> {

    @Autowired
    private OrdenCompraServiceImpl ordenCompraService;

    public OrdenCompraController(OrdenCompraServiceImpl ordenCompraService) {
        super(ordenCompraService);
    }
}
