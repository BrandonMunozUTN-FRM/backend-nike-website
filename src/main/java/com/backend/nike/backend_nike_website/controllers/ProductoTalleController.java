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

    // Devuelve todos los ProductoTalle que hay
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.findAll());
        } catch (Exception e) {
            // Si falla, devuelve error con el mensaje
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Devuelve un ProductoTalle según sus IDs (talle y producto)
    @GetMapping("/{idTalle}/{idProducto}")
    public ResponseEntity<?> getOne(@PathVariable Integer idTalle, @PathVariable Integer idProducto) {
        try {
            ProductoTalleId id = new ProductoTalleId(idTalle, idProducto);
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.findById(id));
        } catch (Exception e) {
            // Si no lo encuentra o hay error, devuelve error
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Guarda un nuevo ProductoTalle
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ProductoTalle entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.save(entity));
        } catch (Exception e) {
            // Si falla al guardar, devuelve error con el mensaje
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Actualiza un ProductoTalle existente según sus IDs
    @PutMapping("/{idTalle}/{idProducto}")
    public ResponseEntity<?> update(@PathVariable Integer idTalle, @PathVariable Integer idProducto,
            @RequestBody ProductoTalle entity) {
        try {
            ProductoTalleId id = new ProductoTalleId(idTalle, idProducto);
            return ResponseEntity.status(HttpStatus.OK).body(productoTalleService.update(id, entity));
        } catch (Exception e) {
            // Devuelve error si no pudo actualizar
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Elimina un ProductoTalle según sus IDs
    @DeleteMapping("/{idTalle}/{idProducto}")
    public ResponseEntity<?> delete(@PathVariable Integer idTalle, @PathVariable Integer idProducto) {
        try {
            ProductoTalleId id = new ProductoTalleId(idTalle, idProducto);
            productoTalleService.delete(id);
            // Responde con 204 si se eliminó correctamente
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            // Devuelve error si hubo problema al eliminar
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
