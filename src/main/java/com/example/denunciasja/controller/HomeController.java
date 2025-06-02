package com.example.denunciasja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/denuncias")
public class HomeController {

    @GetMapping
    public String homeDenuncia() {
        return "denuncias/home-denuncia";
    }
}
