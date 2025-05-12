package com.backend.nike.backend_nike_website.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Direccion> direcciones;
}
