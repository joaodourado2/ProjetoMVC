package com.projetomvc.aplicativo.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetomvc.aplicativo.session.SessionConfiguration;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String redirectInicio() {
        return "redirect:inicio"; 
    }

    @GetMapping("/inicio")
    public String inicio(Model model, HttpSession session){
        if (SessionConfiguration.isConnected(session)){
            model.addAttribute("title", "Tela Inicial");
            return "home/inicio";
        }else{
    	    return "redirect:/login";
        }
    }

	@GetMapping("/index")
    public String redirectToInicio() {
        return "redirect:inicio"; 
    } 
	
    @GetMapping("/home")
    public String redirectHomeToInicio(){
        return ("redirect:/inicio");
    }


}
