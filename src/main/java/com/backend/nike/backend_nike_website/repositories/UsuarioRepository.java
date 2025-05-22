package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.Usuario;

import java.util.Optional;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "usuarios")
public interface UsuarioRepository extends BaseRepository<Usuario, Integer> {

    Optional<Usuario> findByUsuario(String usuario);
}
