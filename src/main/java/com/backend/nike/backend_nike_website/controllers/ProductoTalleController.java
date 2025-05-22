package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.ProductoTalle;
import com.backend.nike.backend_nike_website.entities.ProductoTalleId;
import com.backend.nike.backend_nike_website.services.ProductoTalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/producto-talles")
public class ProductoTalleController {

    @Autowired
    private ProductoTalleService productoTalleService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{idTalle}/{idProducto}")
    public ResponseEntity<?> getOne(@PathVariable Integer idTalle, @PathVariable Integer idProducto) {
        try {
            ProductoTalleId id = new ProductoTalleId(idTalle, idProducto);
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ProductoTalle entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{idTalle}/{idProducto}")
    public ResponseEntity<?> update(@PathVariable Integer idTalle, @PathVariable Integer idProducto, @RequestBody ProductoTalle entity) {
        try {
            ProductoTalleId id = new ProductoTalleId(idTalle, idProducto);
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{idTalle}/{idProducto}")
    public ResponseEntity<?> delete(@PathVariable Integer idTalle, @PathVariable Integer idProducto) {
        try {
            ProductoTalleId id = new ProductoTalleId(idTalle, idProducto);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoTalleService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
