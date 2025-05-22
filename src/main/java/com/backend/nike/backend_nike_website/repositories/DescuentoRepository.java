package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.Descuento;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "descuentos")
public interface DescuentoRepository extends BaseRepository<Descuento, Integer> {
}
