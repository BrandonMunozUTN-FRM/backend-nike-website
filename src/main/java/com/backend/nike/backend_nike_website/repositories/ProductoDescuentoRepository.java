package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.ProductoDescuento;
import com.backend.nike.backend_nike_website.entities.ProductoDescuentoId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "productoDescuentos")
public interface ProductoDescuentoRepository extends JpaRepository<ProductoDescuento, ProductoDescuentoId> {

    @RestResource(path = "byProducto")
    List<ProductoDescuento> findByIdProducto(@Param("idProducto") Integer idProducto);

    @RestResource(path = "byDescuento")
    List<ProductoDescuento> findByIdDescuento(@Param("idDescuento") Integer idDescuento);
}
