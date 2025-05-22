package com.backend.nike.backend_nike_website.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "compra_orden")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class CompraOden extends Base {

    //no hace falta fecha porque ya esta en base
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "usuario_direccion_id")
    private Integer usuarioDireccionId;

    @Column(name = "total")
    private Double total;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Status estado;

    public enum Status {
        PENDING,
        PAID,
        CANCELLED
    }

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", insertable = false, updatable = false),
        @JoinColumn(name = "usuario_direccion_id", referencedColumnName = "direccion_id", insertable = false, updatable = false)
    })
    private UsuariosDireccion usuariosDireccion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuario;
}
