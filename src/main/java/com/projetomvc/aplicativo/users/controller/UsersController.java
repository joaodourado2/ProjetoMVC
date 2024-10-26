package com.projetomvc.aplicativo.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetomvc.aplicativo.users.dao.UsersDao;

@Controller
@RequestMapping("/usuarios")
public class UsersController {

    @GetMapping
    public String users(Model model){
        UsersDao usersModal = new UsersDao();
        model.addAttribute("users", usersModal.getAllUsers());
        return "usuarios/usuarios";
    };

}
