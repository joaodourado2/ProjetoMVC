package com.projetomvc.aplicativo.purchaseRequest.model;

import java.util.List;

public class PurchaseRequest {
    
    private List<Integer> productsId;
    private String description;
    private String requestDate;
    private int idPurchaseRequest;

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
    
    public List<Integer> getProducts() {
        return productsId;
    }

    public void setProducts(List<Integer> productsId) {
        this.productsId = productsId;
    }

    public int getIdPurchaseRequest() {
        return idPurchaseRequest;
    }

    public void setIdPurchaseRequest(int idPurchaseRequest) {
        this.idPurchaseRequest = idPurchaseRequest;
    }
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
