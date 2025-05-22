package com.backend.nike.backend_nike_website.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "producto_descuento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
@IdClass(ProductoDescuentoId.class)
public class ProductoDescuento implements Serializable {

    @Id
    @Column(name = "id_descuento")
    private Integer idDescuento;

    @Id
    @Column(name = "id_producto")
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name = "id_descuento", referencedColumnName = "id", insertable = false, updatable = false)
    private Descuento descuento;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id", insertable = false, updatable = false)
    private Producto producto;
}
