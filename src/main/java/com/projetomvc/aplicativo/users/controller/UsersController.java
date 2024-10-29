package com.projetomvc.aplicativo.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetomvc.aplicativo.users.dao.UsersDao;
import com.projetomvc.aplicativo.users.model.User;
import com.projetomvc.aplicativo.users.service.UserRegistration;;

@Controller
@RequestMapping("/usuarios")
public class UsersController {

    @GetMapping
    public String users(Model model){
        UsersDao usersModal = new UsersDao();
        model.addAttribute("users", usersModal.getAllUsers());
        model.addAttribute("title", "Lista de Usuários");
        return "users/usuarios";
    };

    @GetMapping("/cadastrar-usuario")
    public String cadastroUsuario(Model model){
    	model.addAttribute("title", "Cadastro de Usuário");
        model.addAttribute("user", new User());
        return "users/cadastrar-usuario";
    }

    @PostMapping("/cadastrar-usuario")
    public String cadastrarUsuario(@ModelAttribute User userForm){
        if (UserRegistration.userRegistration(userForm)){
            return ("redirect:/usuarios");
        }else{
            return ("redirect:/");
        }
    }
}
