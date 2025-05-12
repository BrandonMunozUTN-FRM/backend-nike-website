package com.backend.nike.backend_nike_website.repository;

import com.backend.nike.backend_nike_website.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {}