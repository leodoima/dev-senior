package br.com.devsenior.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "Bem-vindo ao servidor da aplicação! \uD83D\uDE80";
    }
}
