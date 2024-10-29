package com.projetomvc.aplicativo.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/produto")
public class ProductController {

	
	@GetMapping
	public String product(HttpSession session,Model model) {
		if (SessionConfiguration.isConnected(session)){
        	model.addAttribute("title", "Tela de Produto");
	    	return "product/produto";
		}else{
			return "redirect:login";
		}
	}
}
