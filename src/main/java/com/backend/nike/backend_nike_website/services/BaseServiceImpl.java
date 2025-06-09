package com.backend.nike.backend_nike_website.services;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.BeanUtils;

import com.backend.nike.backend_nike_website.entities.Base;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;

import jakarta.transaction.Transactional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    
    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    /**
     * Devuelve todos los registros de la entidad.
     * Lanza excepción si no hay resultados.
     */
    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            if (entities.isEmpty()) {
                throw new Exception("Sin resultados obtenidos");
            }
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Devuelve una página con registros de la entidad.
     * Lanza excepción si no hay resultados.
     */
    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            if (entities.isEmpty()) {
                throw new Exception("Sin resultados obtenidos");
            }
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Busca una entidad por su ID.
     * Lanza excepción si no existe.
     */
    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            if (!entityOptional.isPresent()) {
                throw new Exception("No se encontró el recurso con id: " + id);
            }
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Guarda una nueva entidad.
     */
    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            return baseRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Actualiza una entidad existente buscando por ID.
     * Mantiene la fecha de creación original.
     * Lanza excepción si no existe la entidad.
     */
    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            if (!entityOptional.isPresent()) {
                throw new Exception("No se encontró el producto con id: " + id);
            }

            E entityToUpdate = entityOptional.get();
            LocalDateTime createdAt = entityToUpdate.getCreatedAt();

            copyNonNullProperties(entity, entityToUpdate);

            entityToUpdate.setCreatedAt(createdAt);

            return baseRepository.save(entityToUpdate);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    /**
     * Elimina una entidad por su ID.
     * Devuelve true si se eliminó correctamente, sino lanza excepción.
     */
    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)) {
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se encontró el recurso con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void copyNonNullProperties(E source, E target) {
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                if (value != null && !field.getName().equals("id") && !field.getName().equals("createdAt")) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error copiando propiedades", e);
            }
        }
    }

}

