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



@Entity
@Table(name = "usuario_direcciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(UsuariosDireccionId.class)
public class UsuariosDireccion implements Serializable {

    @Id
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Id
    @Column(name = "direccion_id")
    private Integer direccionId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Direccion adress;
}
