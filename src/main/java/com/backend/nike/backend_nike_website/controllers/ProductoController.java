package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Producto;
import com.backend.nike.backend_nike_website.services.ProductoServiceImp;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/categoriasproductos")
public class ProductoController extends BaseController<Producto, Integer> {

    @Autowired
    private ProductoServiceImp productoServiceImp;

    public ProductoController(ProductoServiceImp productoServiceImp) {
        super(productoServiceImp);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoServiceImp.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", e.getMessage()));
        }
    }

}
