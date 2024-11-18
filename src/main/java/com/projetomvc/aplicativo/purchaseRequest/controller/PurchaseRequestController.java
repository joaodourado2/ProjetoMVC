package com.projetomvc.aplicativo.purchaseRequest.controller;

import com.projetomvc.aplicativo.purchaseRequest.model.PurchaseRequest;
import com.projetomvc.aplicativo.purchaseRequest.model.SelectedProduct;
import com.projetomvc.aplicativo.purchaseRequest.service.PurchaseRequestService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.product.model.Product;
import com.projetomvc.aplicativo.product.service.ProductService;
import com.projetomvc.aplicativo.session.SessionConfiguration;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/solicitacao-compras")
public class PurchaseRequestController {

    private final ProductService productService;

    public PurchaseRequestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showPurchaseRequestPage(HttpSession session, Model model, RedirectAttributes redirectAttribute) {
        if (SessionConfiguration.isConnected(session)) {
            List<Product> products = productService.getAllProducts();
            model.addAttribute("title", "Tela de Solicitação de Compras");
            model.addAttribute("products", products);
            model.addAttribute("purchaseRequest", new PurchaseRequest());
            return "purchaseRequest/solicitacao-compras";
        } else {
            addNotLoggedInMessage(redirectAttribute);
            return "redirect:/login";
        }
    }

    @PostMapping
    public String createPurchaseRequest(HttpSession session, @ModelAttribute PurchaseRequest newPurchaseRequest, RedirectAttributes redirectAttribute, @RequestParam("selectedProducts") String selectedProductsJson) {
        if (SessionConfiguration.isConnected(session)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                List<SelectedProduct> selectedProducts = objectMapper.readValue(selectedProductsJson, new TypeReference<List<SelectedProduct>>() {});
                redirectAttribute.addFlashAttribute("messageInfo", PurchaseRequestService.createPurchaseRequest(newPurchaseRequest,selectedProducts));
                return "redirect:/solicitacao-compras";
            } catch (Exception e) {
                e.printStackTrace();
                redirectAttribute.addFlashAttribute("messageInfo",new ServiceMessageReturn(true, "Erro ao criar solicitação de compra!"));
                return "redirect:/solicitacao-compras";
            }
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