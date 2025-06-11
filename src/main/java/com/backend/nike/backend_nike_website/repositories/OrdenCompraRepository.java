package com.backend.nike.backend_nike_website.repositories;

import com.backend.nike.backend_nike_website.entities.OrdenCompra;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompra, Integer> {
    Optional<OrdenCompra> findByPreferenceId(String preferenceId);
}