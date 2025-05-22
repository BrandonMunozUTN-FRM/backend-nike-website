package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.Direccion;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "direcciones")
public interface DireccionRepository extends BaseRepository<Direccion, Integer> {
}
