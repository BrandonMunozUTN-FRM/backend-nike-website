package com.backend.nike.backend_nike_website.repository;

import com.backend.nike.backend_nike_website.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}