package com.projetomvc.aplicativo.purchaseOrders.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.projetomvc.aplicativo.database.service.DataSourceProvider;
import com.projetomvc.aplicativo.product.model.Product;
import com.projetomvc.aplicativo.purchaseOrders.model.PurchaseItemOrder;
import com.projetomvc.aplicativo.purchaseOrders.model.PurchaseOrder;
import com.projetomvc.aplicativo.purchaseRequest.model.PurchaseRequest;

public class ListOrder {

    public List<PurchaseRequest> listAllOrders() {
        List<PurchaseRequest> orders = new ArrayList<>();
        String sql = "SELECT CD_PURCHASE_REQUEST, DS_PURCHASE_JUSTIFICATION, DT_REQUIRED_DATE FROM USER_JAVA.PURCHASE_REQUEST";

        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

             
            while (rs.next()) {
                PurchaseRequest purchaseRequest = new PurchaseRequest();
                purchaseRequest.setIdPurchaseRequest(rs.getInt("CD_PURCHASE_REQUEST"));
                purchaseRequest.setDescription(rs.getString("DS_PURCHASE_JUSTIFICATION"));
                String requestDate = dateFormat.format(rs.getDate("DT_REQUIRED_DATE"));
                purchaseRequest.setRequestDate(requestDate);
                orders.add(purchaseRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public PurchaseRequest getOrderById(Long id) {
        PurchaseRequest order = new PurchaseRequest();
        String sql = "SELECT CD_PURCHASE_REQUEST, DS_PURCHASE_JUSTIFICATION, DT_REQUIRED_DATE FROM USER_JAVA.PURCHASE_REQUEST WHERE CD_PURCHASE_REQUEST = ?";

        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    order.setIdPurchaseRequest(rs.getInt("CD_PURCHASE_REQUEST"));
                    order.setDescription(rs.getString("DS_PURCHASE_JUSTIFICATION"));
                    String requestDate = dateFormat.format(rs.getDate("DT_REQUIRED_DATE"));
                    order.setRequestDate(requestDate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<PurchaseItemOrder> listItemsOrderById(Long id) {
        List<PurchaseItemOrder> items = new ArrayList<>();
        String sql = "\r\n" +
                        "SELECT it.CD_ITPURCHASE_REQUEST,\r\n" + 
                        "       it.CD_PRODUCT,\r\n" + 
                        "       it.CD_QUANTITY_REQUESTED,\r\n" + 
                        "       p.NM_PRODUCT,\r\n" + 
                        "       p.NR_PRICE\r\n" + 
                        "  FROM USER_JAVA.ITPURCHASE_REQUEST  it\r\n" + 
                        "       INNER JOIN USER_JAVA.PRODUCT p ON it.CD_PRODUCT = p.CD_PRODUCT\r\n" + 
                        " WHERE CD_PURCHASE_REQUEST = ?";

        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PurchaseItemOrder item = new PurchaseItemOrder();
                    Product orderProduct = new Product();
                    item.setIdItPurchaseRequest(rs.getInt("CD_ITPURCHASE_REQUEST"));
                    orderProduct.setIdProduct(rs.getInt("CD_PRODUCT"));
                    item.setQuantityRequested(rs.getInt("CD_QUANTITY_REQUESTED"));
                    orderProduct.setNameProduct(rs.getString("NM_PRODUCT"));
                    orderProduct.setPrice(rs.getDouble("NR_PRICE"));
                    item.setProduct(orderProduct);
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static PurchaseOrder getOrderComplete(Long id){
        ListOrder listOrder = new ListOrder();
        PurchaseOrder order = new PurchaseOrder();
        order.setPurchaseRequest(listOrder.getOrderById(id)); 
		order.setPurchaseItemOrder(listOrder.listItemsOrderById(id));
        order.setId(id);
        return order;
    }

}
