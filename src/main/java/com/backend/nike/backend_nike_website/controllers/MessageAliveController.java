package com.backend.nike.backend_nike_website.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/message-alive")
@RequiredArgsConstructor
public class MessageAliveController {

    @GetMapping
    public String message() {
        return "Estamos vivos";
    }

}
