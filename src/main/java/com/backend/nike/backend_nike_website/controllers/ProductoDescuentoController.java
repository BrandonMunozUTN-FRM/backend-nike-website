package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.ProductoDescuento;
import com.backend.nike.backend_nike_website.entities.ProductoDescuentoId;
import com.backend.nike.backend_nike_website.services.ProductoDescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/producto-descuentos")
public class ProductoDescuentoController {

    @Autowired
    private ProductoDescuentoService productoDescuentoService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoDescuentoService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{idDescuento}/{idProducto}")
    public ResponseEntity<?> getOne(@PathVariable Integer idDescuento, @PathVariable Integer idProducto) {
        try {
            ProductoDescuentoId id = new ProductoDescuentoId(idDescuento, idProducto);
            return ResponseEntity.status(HttpStatus.OK).body(productoDescuentoService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ProductoDescuento entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoDescuentoService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{idDescuento}/{idProducto}")
    public ResponseEntity<?> update(@PathVariable Integer idDescuento, @PathVariable Integer idProducto, @RequestBody ProductoDescuento entity) {
        try {
            ProductoDescuentoId id = new ProductoDescuentoId(idDescuento, idProducto);
            return ResponseEntity.status(HttpStatus.OK).body(productoDescuentoService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{idDescuento}/{idProducto}")
    public ResponseEntity<?> delete(@PathVariable Integer idDescuento, @PathVariable Integer idProducto) {
        try {
            ProductoDescuentoId id = new ProductoDescuentoId(idDescuento, idProducto);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoDescuentoService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/byProducto/{idProducto}")
    public ResponseEntity<?> getByProducto(@PathVariable Integer idProducto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoDescuentoService.findByIdProducto(idProducto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
