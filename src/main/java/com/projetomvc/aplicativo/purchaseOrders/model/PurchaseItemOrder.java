package com.projetomvc.aplicativo.purchaseOrders.model;

import com.projetomvc.aplicativo.product.model.Product;

public class PurchaseItemOrder {

    private int idItPurchaseRequest;
    private int quantityRequested;
    private int quantityAproved;
    private Product product;
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
        this.setQuantityAproved(quantityRequested);
    }

    public int getQuantityAproved() {
        return quantityAproved;
    }

    public void setQuantityAproved(int quantityAproved) {
        this.quantityAproved = quantityAproved;
    }

    public int getIdItPurchaseRequest() {
        return idItPurchaseRequest;
    }

    public void setIdItPurchaseRequest(int idItPurchaseRequest) {
        this.idItPurchaseRequest = idItPurchaseRequest;
    }

}
