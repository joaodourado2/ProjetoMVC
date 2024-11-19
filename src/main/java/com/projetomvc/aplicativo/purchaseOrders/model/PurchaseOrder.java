package com.projetomvc.aplicativo.purchaseOrders.model;

import java.util.List;

import com.projetomvc.aplicativo.purchaseRequest.model.PurchaseRequest;

public class PurchaseOrder {

    long id;
    PurchaseRequest purchaseRequest;
    List<PurchaseItemOrder> purchaseItemOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public List<PurchaseItemOrder> getPurchaseItemOrder() {
        return purchaseItemOrder;
    }

    public void setPurchaseItemOrder(List<PurchaseItemOrder> purchaseItemOrder) {
        this.purchaseItemOrder = purchaseItemOrder;
    }

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }
}
