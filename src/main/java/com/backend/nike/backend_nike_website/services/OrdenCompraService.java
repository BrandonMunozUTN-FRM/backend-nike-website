package com.backend.nike.backend_nike_website.services;

import com.backend.nike.backend_nike_website.entities.OrdenCompra;
import java.util.List;

public interface OrdenCompraService extends BaseService<OrdenCompra, Integer> {
        OrdenCompra generarOrdenCompra(List<Long> ids) throws Exception;
}
