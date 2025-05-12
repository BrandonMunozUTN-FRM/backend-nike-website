package com.backend.nike.backend_nike_website.controller;

import com.backend.nike.backend_nike_website.entity.Talle;
import com.backend.nike.backend_nike_website.service.TalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talles")
public class TalleController {

    @Autowired
    private TalleService talleService;

    @GetMapping
    public List<Talle> listar() {
        return talleService.listar();
    }

    @PostMapping
    public Talle guardar(@RequestBody Talle talle) {
        return talleService.guardar(talle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talle> obtenerPorId(@PathVariable Long id) {
        return talleService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        talleService.eliminar(id);
    }
}
