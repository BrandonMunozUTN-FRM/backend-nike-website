package com.backend.nike.backend_nike_website.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

// Interfaz que define los métodos para interactuar con Cloudinary
public interface CloudinaryService {

    // Método para subir un archivo a Cloudinary
    public default String uploadFile(MultipartFile file) {
        return null; // Implementación por defecto que retorna null
    }

    // Método para eliminar una imagen de Cloudinary
    public ResponseEntity<String> deleteImage(String publicId, UUID uuid);
}
