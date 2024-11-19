package com.projetomvc.aplicativo.purchaseOrders.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.purchaseOrders.service.ListOrder;
import com.projetomvc.aplicativo.session.SessionConfiguration;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ordem-compra")
public class PurchaseOrdersController {

    @GetMapping
	public String ordemCompra(HttpSession session,Model model,RedirectAttributes redirectAttribute) {
		if (SessionConfiguration.isConnected(session)){
            ListOrder listOrder = new ListOrder();
            model.addAttribute("orders", listOrder.listAllOrders());
        	model.addAttribute("title", "Ordens de Compra");
			return "purchaseOrders/ordem-compra";
		}else{
			ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn(true, "Usúario não logado!");
            redirectAttribute.addFlashAttribute("messageInfo",serviceMessageReturn);
			return "redirect:login";
		}
	}

	@GetMapping("/id={id}")
    public String viewOrderDetails(@PathVariable("id") Long id, HttpSession session, Model model, RedirectAttributes redirectAttribute) {
        if (SessionConfiguration.isConnected(session)) {
            model.addAttribute("order", ListOrder.getOrderComplete(id));
            model.addAttribute("title", "Detalhes da Ordem de Compra");
            return "purchaseOrders/ordem-detalhe";
        } else {
            ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn(true, "Usuário não logado!");
            redirectAttribute.addFlashAttribute("messageInfo", serviceMessageReturn);
            return "redirect:/login";
        }
    }

}
