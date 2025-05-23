package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.UsuariosDireccion;
import com.backend.nike.backend_nike_website.entities.UsuariosDireccionId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "usuarioAddresses")
public interface UsuariosDireccionRepository extends JpaRepository<UsuariosDireccion, UsuariosDireccionId> {

    // Busca todas las direcciones asociadas a un usuario específico
    @RestResource(path = "byUsuario")
    List<UsuariosDireccion> findByUsuarioId(@Param("usuarioId") Integer usuarioId);

    // Busca todas las relaciones que tengan una dirección específica
    @RestResource(path = "byDireccion")
    List<UsuariosDireccion> findByDireccionId(@Param("direccionId") Integer direccionId);
}
