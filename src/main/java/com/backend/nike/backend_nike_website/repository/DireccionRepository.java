package com.backend.nike.backend_nike_website.repository;

import com.backend.nike.backend_nike_website.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository  extends JpaRepository<Direccion, Long> {}