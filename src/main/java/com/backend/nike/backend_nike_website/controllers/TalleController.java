package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.Talle;
import com.backend.nike.backend_nike_website.services.TalleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/talles")
public class TalleController extends BaseController<Talle, Integer> {

    @Autowired
    private TalleServiceImp talleServiceImp;

    public TalleController(TalleServiceImp talleServiceImp) {
        super(talleServiceImp);
    }
}
