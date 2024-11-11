package com.projetomvc.aplicativo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.login.model.UserLogin;
import com.projetomvc.aplicativo.login.service.ValidateLogin;
import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(HttpSession session, Model model) {
        if (SessionConfiguration.isConnected(session)){
            return "redirect:inicio";
        }else{
    	    model.addAttribute("title", "Login Sistema");
    	    model.addAttribute("user", new UserLogin());
            return "login/login";
        }
    }

    @PostMapping
    public String validateLogin(@ModelAttribute UserLogin userForm, RedirectAttributes redirectAttribute, HttpSession session){
        if (ValidateLogin.validateLogin(userForm.getIdUser(), userForm.getDsPassword())){
            SessionConfiguration.setSession(session, userForm.getIdUser());
            return "redirect:/inicio";
        }else{
            ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn(true, "Usúario ou senha inválido!");
            redirectAttribute.addFlashAttribute("messageInfo",serviceMessageReturn);
            return "redirect:/login";
        }
    }
}
