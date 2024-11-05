package com.projetomvc.aplicativo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutContoller {

    @GetMapping
    public String logout(HttpSession session){
        SessionConfiguration.closeSession(session);
        return "redirect:/";
    }


}
