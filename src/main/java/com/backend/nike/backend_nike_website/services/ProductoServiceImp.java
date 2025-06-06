package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.Talle;
import com.backend.nike.backend_nike_website.repositories.TalleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.nike.backend_nike_website.entities.Producto;
import com.backend.nike.backend_nike_website.repositories.BaseRepository;
import com.backend.nike.backend_nike_website.repositories.ProductoRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductoServiceImp extends BaseServiceImpl<Producto, Integer> implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private TalleRepository talleRepository;

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

    // Sobrescribo save para asignar los talles a partir de los IDs
    @Override
    public Producto save(Producto entity) throws Exception {
        asignarTallesPorId(entity);
        return super.save(entity);
    }

    // Sobrescribo update para asignar los talles a partir de los IDs
    @Override
    public Producto update(Integer id, Producto entity) throws Exception {
        asignarTallesPorId(entity);
        return super.update(id, entity);
    }

    // Método privado para buscar y asignar talles completos a partir de la lista recibida (solo con IDs)
    private void asignarTallesPorId(Producto producto) throws Exception {
        if (producto.getTalles() != null && !producto.getTalles().isEmpty()) {
            List<Talle> talles = new ArrayList<>();
            for (Talle talle : producto.getTalles()) {
                Integer talleId = talle.getId();
                Talle talleEntity = talleRepository.findById(talleId)
                        .orElseThrow(() -> new Exception("Talle no encontrado con id: " + talleId));
                talles.add(talleEntity);
            }
            producto.setTalles(talles);
        }
    }
}
