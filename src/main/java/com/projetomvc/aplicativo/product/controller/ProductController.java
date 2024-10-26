package com.projetomvc.aplicativo.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/produto")
public class ProductController {

	
	@GetMapping
	public String product(Model model) {
        model.addAttribute("title", "Tela de Produto");
	    return "produto/produto";
	}
}
