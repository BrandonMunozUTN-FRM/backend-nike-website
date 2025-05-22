package com.backend.nike.backend_nike_website.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "descuento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Descuento extends Base {

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "descuento_porcentaje")
    private Integer descuentoPercentage;
}
