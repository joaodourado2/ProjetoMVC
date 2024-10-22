package com.projetomvc.aplicativo.produto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetomvc.aplicativo.produto.model.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	private Produto protudoTeste = new Produto();
	
	@GetMapping
	public String produto(Model model) {
		model.addAttribute("prTeste", protudoTeste.getNomeProduto());
	    return "produto/produto";
	}
}
