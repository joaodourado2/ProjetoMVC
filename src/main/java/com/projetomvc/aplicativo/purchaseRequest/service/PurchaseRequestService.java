package com.projetomvc.aplicativo.purchaseRequest.service;

import com.projetomvc.aplicativo.purchaseRequest.model.PurchaseRequest;
import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;

public class PurchaseRequestService {
    public static ServiceMessageReturn createPurchaseRequest(PurchaseRequest newPurchaseRequest) {
        return new ServiceMessageReturn(true, "Solicitação de compra criada com sucesso!");
    }
}
