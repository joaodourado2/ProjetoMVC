package com.projetomvc.aplicativo.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetomvc.aplicativo.product.model.Product;
import com.projetomvc.aplicativo.product.service.CreateProductService;
import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/produto")
public class ProductController {

	
	@GetMapping
	public String product(HttpSession session,Model model) {
		if (SessionConfiguration.isConnected(session)){
        	model.addAttribute("title", "Tela de Produto");
	    	model.addAttribute("product",new Product());
			return "product/produto";
		}else{
			return "redirect:login";
		}
	}

	@PostMapping
	public String createProduct(HttpSession session,Model model,@ModelAttribute Product newProduct) {
		if (SessionConfiguration.isConnected(session)){
			if (CreateProductService.createProductService(newProduct)){
        		return "redirect:produto";
			}
			else{
				return "redirect:inicio";
			}
		}else{
			return "redirect:login";
		}
	}
}
