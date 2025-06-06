package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "categoriasproductos")
public interface ProductoRepository extends BaseRepository<Producto, Integer> {

    // Método para buscar productos filtrando por nombre o descripción, con soporte de paginación
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:filtro% OR p.descripcion LIKE %:filtro%")
    Page<Producto> search(@Param("filtro") String filtro, Pageable pageable);

}
