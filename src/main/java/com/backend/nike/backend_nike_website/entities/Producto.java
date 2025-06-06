package com.backend.nike.backend_nike_website.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "categoriasproductos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto extends Base {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "categoria_id")
    private Integer categoriaId;

    @Column(name = "color")
    private short color;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "genero")
    private String genero;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "producto_talle",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "talle_id")
    )
    private List<Talle> talles;
}