package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Usuario;
import com.backend.nike.backend_nike_website.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/usuarios")
public class UsuarioController extends BaseController<Usuario, Integer> {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    public UsuarioController(UsuarioServiceImpl usuarioServiceImpl) {
        super(usuarioServiceImpl);
    }

}
