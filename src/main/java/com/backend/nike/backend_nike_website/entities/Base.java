package com.backend.nike.backend_nike_website.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.hibernate.annotations.Immutable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class Base implements Serializable {

    // ID autogenerado para cada entidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Fecha y hora de creación, se guarda solo una vez y no cambia
    @Immutable
    private LocalDateTime createdAt;

    // Fecha y hora de la última actualización
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Antes de guardar por primera vez, asigna la fecha y hora actual de Buenos Aires
    @PrePersist
    public void prePersist() {
        this.createdAt = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")).toLocalDateTime();
    }

    // Antes de actualizar, actualiza la fecha y hora con el momento actual de Buenos Aires
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires")).toLocalDateTime();
    }
}
