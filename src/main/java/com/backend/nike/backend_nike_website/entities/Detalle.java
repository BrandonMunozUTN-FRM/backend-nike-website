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
@Table(name = "detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Detalle extends Base {

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "oden_id")
    private Integer ordenId;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "oden_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CompraOden compraOden;
}
