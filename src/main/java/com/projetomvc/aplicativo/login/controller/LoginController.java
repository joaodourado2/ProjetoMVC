package com.projetomvc.aplicativo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetomvc.aplicativo.login.model.User;
import com.projetomvc.aplicativo.login.service.ValidateLogin;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(Model model) {
    	model.addAttribute("title", "Login Sistema");
    	model.addAttribute("user", new User());
        return "login/login"; 
    }

    @PostMapping("login")
    public String validateLogin(@ModelAttribute User userForm, RedirectAttributes redirectAttribute){
        if (ValidateLogin.validateLogin(userForm.getUserName(), userForm.getUserPass())){
            return "redirect:/inicio";
        }else{
            redirectAttribute.addFlashAttribute("error","Usuário Inválido!");
            return "redirect:/login";
        }
    }
}
