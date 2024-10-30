package com.projetomvc.aplicativo.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetomvc.aplicativo.users.dao.UsersDao;
import com.projetomvc.aplicativo.users.model.User;
import com.projetomvc.aplicativo.users.service.UserRegistration;

import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuarios")
public class UsersController {

    @GetMapping
    public String users(HttpSession session, Model model){
        if (SessionConfiguration.isConnected(session)){
            UsersDao usersModal = new UsersDao();
            model.addAttribute("users", usersModal.getAllUsers());
            model.addAttribute("title", "Lista de Usuários");
            return "users/usuarios";
        }else{
            return "redirect:login";
        }
    };

    @GetMapping("/cadastrar-usuario")
    public String cadastroUsuario(HttpSession session, Model model){
        if (SessionConfiguration.isConnected(session)){
            model.addAttribute("title", "Cadastro de Usuário");
            model.addAttribute("user", new User());
            return "users/cadastrar-usuario";
        }else{
            return "redirect:/login";
        }
    }

    @PostMapping("/cadastrar-usuario")
    public String cadastrarUsuario(HttpSession session,@ModelAttribute User userForm,RedirectAttributes redirectAttributes){
        if (SessionConfiguration.isConnected(session)){
            if (UserRegistration.userRegistration(userForm)){
                return "redirect:/usuarios";
            }else{
                redirectAttributes.addFlashAttribute("error", "Ocorreu um erro ao cadastrar o Usuário!");
                return "redirect:/usuarios/cadastrar-usuario";
            }
        }else{
            return "redirect:/login";
        }
    }
}
