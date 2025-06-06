package com.backend.nike.backend_nike_website.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items_orden")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemOrden extends Base {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "orden_id")
    private OrdenCompra ordenCompra;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;
}
