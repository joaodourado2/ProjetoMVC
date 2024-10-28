package com.projetomvc.aplicativo.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MenuController {

    @GetMapping("/menu")
    public String menu(){
        return ("menu");
    }
}
