package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.UsuariosDireccion;
import com.backend.nike.backend_nike_website.entities.UsuariosDireccionId;
import com.backend.nike.backend_nike_website.repositories.UsuariosDireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosDireccionService {
    // Inyectamos el repositorio de UsuariosDireccion
    @Autowired
    private UsuariosDireccionRepository usuariosDireccionRepository;

    // Método para obtener todos los registros de UsuariosDireccion
    @Transactional
    public List<UsuariosDireccion> findAll() throws Exception {
        try {
            return usuariosDireccionRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para buscar un registro por su ID compuesto
    @Transactional
    public UsuariosDireccion findById(UsuariosDireccionId id) throws Exception {
        try {
            Optional<UsuariosDireccion> entityOptional = usuariosDireccionRepository.findById(id);
            return entityOptional.get(); // Devuelve el registro si existe, o lanza NoSuchElementException
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para buscar direcciones asociadas a un usuario por su ID
    @Transactional
    public List<UsuariosDireccion> findByUsuarioId(Integer usuarioId) throws Exception {
        try {
            return usuariosDireccionRepository.findByUsuarioId(usuarioId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para guardar un nuevo registro
    @Transactional
    public UsuariosDireccion save(UsuariosDireccion entity) throws Exception {
        try {
            entity = usuariosDireccionRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para actualizar un registro existente
    @Transactional
    public UsuariosDireccion update(UsuariosDireccionId id, UsuariosDireccion entity) throws Exception {
        try {
            Optional<UsuariosDireccion> entityOptional = usuariosDireccionRepository.findById(id);
            if (!entityOptional.isPresent()) {
                throw new Exception("No se encontró el registro con id: " + id);
            }

            UsuariosDireccion usuariosDireccion = entityOptional.get();
            // Copiamos propiedades del nuevo objeto al existente, menos las claves (usuarioId y direccionId)
            BeanUtils.copyProperties(entity, usuariosDireccion, "usuarioId", "direccionId");
            return usuariosDireccion;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para eliminar un registro por su ID
    @Transactional
    public boolean delete(UsuariosDireccionId id) throws Exception {
        try {
            if (usuariosDireccionRepository.existsById(id)) {
                usuariosDireccionRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No existe el registro con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
