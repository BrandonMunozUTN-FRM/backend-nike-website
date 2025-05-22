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
    
    @Autowired
    private ProductoDescuentoRepository productoDescuentoRepository;
    
    @Transactional
    public List<ProductoDescuento> findAll() throws Exception {
        try {
            return productoDescuentoRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Transactional
    public ProductoDescuento findById(ProductoDescuentoId id) throws Exception {
        try {
            Optional<ProductoDescuento> entityOptional = productoDescuentoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Transactional
    public ProductoDescuento save(ProductoDescuento entity) throws Exception {
        try {
            entity = productoDescuentoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Transactional
    public ProductoDescuento update(ProductoDescuentoId id, ProductoDescuento entity) throws Exception {
        try {
            Optional<ProductoDescuento> entityOptional = productoDescuentoRepository.findById(id);
            if (!entityOptional.isPresent()) {
                throw new Exception("No se encontró el registro con id: " + id);
            }
            ProductoDescuento productoDescuento = entityOptional.get();
            BeanUtils.copyProperties(entity, productoDescuento, "idDescuento", "idProducto");
            return productoDescuento;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Transactional
    public boolean delete(ProductoDescuentoId id) throws Exception {
        try {
            if (productoDescuentoRepository.existsById(id)) {
                productoDescuentoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No existe el registro con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<ProductoDescuento> findByIdProducto(Integer idProducto) throws Exception {
        try {
            return productoDescuentoRepository.findByIdProducto(idProducto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

} 