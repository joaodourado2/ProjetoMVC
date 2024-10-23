package com.projetomvc.aplicativo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetomvc.aplicativo.login.model.User;

@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping
    public String redirectToLogin() {
        return "redirect:login"; 
    }
	
	@GetMapping("index")
    public String redirectIndToLogin() {
        return "redirect:login"; 
    }
	
    @GetMapping("login")
    public String login(Model model) {
    	model.addAttribute("user", new User());
        return "login/login"; 
    }

    @PostMapping("login")
    public String validateLogin(@ModelAttribute User userForm, RedirectAttributes redirectAttribute){
        if ("teste".equals(userForm.getUserName())){
            return "produto/produto";
        }else{
            redirectAttribute.addFlashAttribute("error","Usuário Inválido!");
            return "redirect:/login";
        }
    }
}
