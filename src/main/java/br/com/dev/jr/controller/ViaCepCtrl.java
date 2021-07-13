package br.com.dev.jr.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ViaCepCtrl {


    @GetMapping("/")
    public String mostrarNome(){
        return "Henrique Santiago";
    }


}
