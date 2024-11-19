package com.projetomvc.aplicativo.purchaseOrders.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.projetomvc.aplicativo.database.service.DataSourceProvider;
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

}
