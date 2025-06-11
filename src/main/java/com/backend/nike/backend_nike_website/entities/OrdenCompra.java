package com.backend.nike.backend_nike_website.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orden_compra")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenCompra extends Base {

    private Double total;

    private LocalDate fechaCompra;

    private String estado;

    private String preferenceId;

    @ManyToMany
    @JsonIgnoreProperties("ordenCompras")
    @JoinTable(
            name = "orden_compra_detalle",
            joinColumns = @JoinColumn(name = "orden_compra_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("ordenesCompra")
    private Usuario usuario;
}
