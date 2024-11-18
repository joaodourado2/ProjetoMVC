package com.projetomvc.aplicativo.purchaseRequest.controller;

import com.projetomvc.aplicativo.purchaseRequest.model.PurchaseRequest;
import com.projetomvc.aplicativo.purchaseRequest.service.PurchaseRequestService;
import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.session.SessionConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/purchaseRequest")
public class PurchaseRequestController {


    @GetMapping
    public String showPurchaseRequestPage(HttpSession session, Model model, RedirectAttributes redirectAttribute) {
        if (SessionConfiguration.isConnected(session)) {
            model.addAttribute("title", "Tela de Solicitação de Compras");
            model.addAttribute("purchaseRequest", new PurchaseRequest());
            return "purchaseRequest/solicitacao-compras";
        } else {
            addNotLoggedInMessage(redirectAttribute);
            return "redirect:/login";
        }
    }

    @PostMapping
    public String createPurchaseRequest(HttpSession session, @ModelAttribute PurchaseRequest newPurchaseRequest, RedirectAttributes redirectAttribute) {
        if (SessionConfiguration.isConnected(session)) {
            ServiceMessageReturn serviceMessageReturn = PurchaseRequestService.createPurchaseRequest(newPurchaseRequest);
            redirectAttribute.addFlashAttribute("messageInfo", serviceMessageReturn);
            return "redirect:/solicitacao-compras";
        } else {
            addNotLoggedInMessage(redirectAttribute);
            return "redirect:/login";
        }
    }

    private void addNotLoggedInMessage(RedirectAttributes redirectAttribute) {
        ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn(true, "Usuário não logado!");
        redirectAttribute.addFlashAttribute("messageInfo", serviceMessageReturn);
    }
}