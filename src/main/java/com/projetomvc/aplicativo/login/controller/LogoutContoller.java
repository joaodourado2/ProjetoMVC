package com.projetomvc.aplicativo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutContoller {

    @GetMapping
    public String logout(HttpSession session,RedirectAttributes redirectAttribute){
        SessionConfiguration.closeSession(session);
        ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn(false, "Usúario deslogado!");
        redirectAttribute.addFlashAttribute("messageInfo",serviceMessageReturn);
        return "redirect:/";
    }


}
