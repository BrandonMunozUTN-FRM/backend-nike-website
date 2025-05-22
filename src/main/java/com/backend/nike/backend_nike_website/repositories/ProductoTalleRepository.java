package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.ProductoTalle;
import com.backend.nike.backend_nike_website.entities.ProductoTalleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoTalleRepository extends JpaRepository<ProductoTalle, ProductoTalleId> {
}
