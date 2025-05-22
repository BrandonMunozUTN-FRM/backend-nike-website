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
@Table(name = "producto_talle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
@IdClass(ProductoTalleId.class)
public class ProductoTalle implements Serializable {

    @Id
    @Column(name = "id_talle")
    private Integer idTalle;

    @Id
    @Column(name = "id_producto")
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name = "id_talle", referencedColumnName = "id", insertable = false, updatable = false)
    private Talle talle;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id", insertable = false, updatable = false)
    private Producto producto;
}
