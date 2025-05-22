package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.UsuariosDireccion;
import com.backend.nike.backend_nike_website.entities.UsuariosDireccionId;
import com.backend.nike.backend_nike_website.services.UsuariosDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/usuario-direcciones")
public class UsuariosDireccionController {

    @Autowired
    private UsuariosDireccionService usuariosDireccionService;

    // Devuelve todas las direcciones de usuarios
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosDireccionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Devuelve una dirección de usuario específica según sus IDs compuestos
    @GetMapping("/{usuarioId}/{direccionId}")
    public ResponseEntity<?> getOne(@PathVariable Integer usuarioId, @PathVariable Integer direccionId) {
        try {
            UsuariosDireccionId id = new UsuariosDireccionId(usuarioId, direccionId);
            return ResponseEntity.status(HttpStatus.OK).body(usuariosDireccionService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Devuelve todas las direcciones asociadas a un usuario específico
    @GetMapping("/byUsuario/{usuarioId}")
    public ResponseEntity<?> getByUsuarioId(@PathVariable Integer usuarioId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosDireccionService.findByUsuarioId(usuarioId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Guarda una nueva dirección para un usuario
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody UsuariosDireccion entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosDireccionService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Actualiza una dirección existente identificada por usuario y dirección
    @PutMapping("/{usuarioId}/{direccionId}")
    public ResponseEntity<?> update(@PathVariable Integer usuarioId, @PathVariable Integer direccionId, @RequestBody UsuariosDireccion entity) {
        try {
            UsuariosDireccionId id = new UsuariosDireccionId(usuarioId, direccionId);
            return ResponseEntity.status(HttpStatus.OK).body(usuariosDireccionService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    // Elimina una dirección de usuario específica
    @DeleteMapping("/{usuarioId}/{direccionId}")
    public ResponseEntity<?> delete(@PathVariable Integer usuarioId, @PathVariable Integer direccionId) {
        try {
            UsuariosDireccionId id = new UsuariosDireccionId(usuarioId, direccionId);
            usuariosDireccionService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
