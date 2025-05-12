package com.backend.nike.backend_nike_website.controller;

import com.backend.nike.backend_nike_website.entity.Genero;
import com.backend.nike.backend_nike_website.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> listar() {
        return generoService.listar();
    }

    @PostMapping
    public Genero guardar(@RequestBody Genero genero) {
        return generoService.guardar(genero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> obtenerPorId(@PathVariable Long id) {
        return generoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        generoService.eliminar(id);
    }
}
