package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Type;
import com.backend.nike.backend_nike_website.services.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/types")
public class TypeController extends BaseController<Type, Integer> {

    @Autowired
    private TypeServiceImpl typeServiceImpl;

    public TypeController(TypeServiceImpl typeServiceImpl) {
        super(typeServiceImpl);
    }

}
