package com.projetomvc.aplicativo.purchaseRequest.model;

import java.util.List;

public class PurchaseRequest {

    private List<Integer> productsId;
    private String description;
    private String requestDate;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
