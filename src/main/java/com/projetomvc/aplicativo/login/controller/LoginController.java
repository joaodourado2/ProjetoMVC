package com.projetomvc.aplicativo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String login() {
        return "login/login"; 
    }
}
