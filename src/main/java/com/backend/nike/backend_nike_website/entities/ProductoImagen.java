package com.backend.nike.backend_nike_website.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "producto_imagen")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class ProductoImagen extends Base {

    @Column(name = "link")
    private String link;

    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "is_principal_producto_imagen") //por defecto es false, osea que si se agregan imagennes al producto solo se debe determinar cual es la principal, sino, dejar vacío
    private boolean isPrincipalProductoImagen;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Producto producto;
}
