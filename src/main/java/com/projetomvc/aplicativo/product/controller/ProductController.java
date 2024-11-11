package com.projetomvc.aplicativo.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.product.model.Product;
import com.projetomvc.aplicativo.product.service.CreateProductService;
import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/produto")
public class ProductController {

	
	@GetMapping
	public String product(HttpSession session,Model model,RedirectAttributes redirectAttribute) {
		if (SessionConfiguration.isConnected(session)){
        	model.addAttribute("title", "Tela de Produto");
	    	model.addAttribute("product",new Product());
			return "product/produto";
		}else{
			ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn(true, "Usúario não logado!");
            redirectAttribute.addFlashAttribute("messageInfo",serviceMessageReturn);
			return "redirect:login";
		}
	}

	@PostMapping
	public String createProduct(HttpSession session,Model model,@ModelAttribute Product newProduct,RedirectAttributes redirectAttribute) {
		if (SessionConfiguration.isConnected(session)){
			ServiceMessageReturn serviceMessageReturn = CreateProductService.createProductService(newProduct);
			redirectAttribute.addFlashAttribute("messageInfo",serviceMessageReturn);
        	return "redirect:produto";
		}else{
			ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn(true, "Usúario não logado!");
            redirectAttribute.addFlashAttribute("messageInfo",serviceMessageReturn);
			return "redirect:login";
		}
	}
}
