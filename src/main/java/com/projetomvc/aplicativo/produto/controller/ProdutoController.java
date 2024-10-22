package com.projetomvc.aplicativo.produto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping
    public String produto() {
        return "produto/produto"; 
    }
}
