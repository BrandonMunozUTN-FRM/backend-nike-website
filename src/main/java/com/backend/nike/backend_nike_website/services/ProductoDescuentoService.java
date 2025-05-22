package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.ProductoDescuento;
import com.backend.nike.backend_nike_website.entities.ProductoDescuentoId;
import com.backend.nike.backend_nike_website.repositories.ProductoDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoDescuentoService {
    // Inyectamos el repositorio que maneja las operaciones de ProductoDescuento
    @Autowired
    private ProductoDescuentoRepository productoDescuentoRepository;

    // Obtiene todos los registros de ProductoDescuento
    @Transactional
    public List<ProductoDescuento> findAll() throws Exception {
        try {
            return productoDescuentoRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Busca un registro por su id compuesto
    @Transactional
    public ProductoDescuento findById(ProductoDescuentoId id) throws Exception {
        try {
            Optional<ProductoDescuento> entityOptional = productoDescuentoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Guarda un nuevo registro de ProductoDescuento en la base de datos
    @Transactional
    public ProductoDescuento save(ProductoDescuento entity) throws Exception {
        try {
            entity = productoDescuentoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Actualiza un registro existente identificado por su id compuesto
    @Transactional
    public ProductoDescuento update(ProductoDescuentoId id, ProductoDescuento entity) throws Exception {
        try {
            Optional<ProductoDescuento> entityOptional = productoDescuentoRepository.findById(id);

            // Verificamos si existe el registro a actualizar
            if (!entityOptional.isPresent()) {
                throw new Exception("El registro especificado no fue encontrado: " + id);
            }

            ProductoDescuento productoDescuento = entityOptional.get();

            // Copiamos las propiedades excepto las claves primarias
            BeanUtils.copyProperties(entity, productoDescuento, "idDescuento", "idProducto");

            return productoDescuento;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Elimina un registro por su id compuesto
    @Transactional
    public boolean delete(ProductoDescuentoId id) throws Exception {
        try {
            // Verificamos que exista antes de eliminar
            if (productoDescuentoRepository.existsById(id)) {
                productoDescuentoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se localizó el registro para eliminar con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Obtiene todos los descuentos asociados a un producto en específico
    @Transactional
    public List<ProductoDescuento> findByIdProducto(Integer idProducto) throws Exception {
        try {
            return productoDescuentoRepository.findByIdProducto(idProducto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
