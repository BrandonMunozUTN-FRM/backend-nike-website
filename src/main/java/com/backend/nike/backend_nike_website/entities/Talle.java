package com.backend.nike.backend_nike_website.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "talle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Talle extends Base {

    @Column(name = "numero")
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "system_type")
    private SystemType systemType;

    public enum SystemType {
        EU, US, UK, CM
    }

}
