package com.backend.nike.backend_nike_website.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.nike.backend_nike_website.entities.Producto;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.ProductoRepository;

@Service
public class ProductoServiceImp extends BaseServiceImpl<Producto, Integer> implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Constructor que recibe el repositorio base y se lo pasa a la clase padre
    public ProductoServiceImp(BaseRepository<Producto, Integer> baseRepository) {
        super(baseRepository);
    }

    // Método para buscar productos por un filtro y paginar los resultados
    @Override
    public Page<Producto> search(String filtro, Pageable pageable) throws Exception {
        try {
            return productoRepository.search(filtro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
