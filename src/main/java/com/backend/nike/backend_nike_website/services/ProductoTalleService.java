package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.ProductoTalle;
import com.backend.nike.backend_nike_website.entities.ProductoTalleId;
import com.backend.nike.backend_nike_website.repositories.ProductoTalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoTalleService {

    // Inyectamos el repositorio que maneja ProductoTalle
    @Autowired
    private ProductoTalleRepository productoTalleRepository;

    // Método para obtener todos los registros de ProductoTalle
    @Transactional
    public List<ProductoTalle> findAll() throws Exception {
        try {
            return productoTalleRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para obtener un registro por su ID compuesto
    @Transactional
    public ProductoTalle findById(ProductoTalleId id) throws Exception {
        try {
            Optional<ProductoTalle> entityOptional = productoTalleRepository.findById(id);
            return entityOptional.get(); // Puede lanzar NoSuchElementException si no existe
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para guardar un nuevo registro
    @Transactional
    public ProductoTalle save(ProductoTalle entity) throws Exception {
        try {
            entity = productoTalleRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para actualizar un registro existente
    @Transactional
    public ProductoTalle update(ProductoTalleId id, ProductoTalle entity) throws Exception {
        try {
            Optional<ProductoTalle> entityOptional = productoTalleRepository.findById(id);
            if (!entityOptional.isPresent()) {
                throw new Exception("No se encontró el registro con id: " + id);
            }

            ProductoTalle productoTalle = entityOptional.get();
            // Copiamos propiedades excepto las claves (idTalle e idProducto)
            BeanUtils.copyProperties(entity, productoTalle, "idTalle", "idProducto");

            return productoTalle;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para eliminar un registro por su ID
    @Transactional
    public boolean delete(ProductoTalleId id) throws Exception {
        try {
            if (productoTalleRepository.existsById(id)) {
                productoTalleRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No existe el registro con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
