package com.backend.nike.backend_nike_website.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "talles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Talle extends Base {

    @Column(name = "numero")
    private String numero;
}