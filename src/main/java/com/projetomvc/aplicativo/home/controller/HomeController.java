package com.projetomvc.aplicativo.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String redirectInicio() {
        return "redirect:inicio"; 
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "home/inicio";
    }

	@GetMapping("/index")
    public String redirectToInicio() {
        return "redirect:inicio"; 
    }
	
    @GetMapping("/home")
    public String redirectHomeToInicio(){
        return ("redirect:inicio");
    }


}
