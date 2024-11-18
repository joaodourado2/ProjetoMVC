package com.projetomvc.aplicativo.purchaseRequest.service;

import com.projetomvc.aplicativo.purchaseRequest.model.PurchaseRequest;
import com.projetomvc.aplicativo.purchaseRequest.model.SelectedProduct;

import java.sql.*;
import java.util.List;

import com.projetomvc.aplicativo.database.service.DataSourceProvider;
import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;

public class PurchaseRequestService {
    public static ServiceMessageReturn createPurchaseRequest(PurchaseRequest newPurchaseRequest,List<SelectedProduct> selectedProducts) {
        try(Connection connection = DataSourceProvider.getDataSource().getConnection()){
            Statement seqStmt = connection.createStatement();
            ResultSet rs = seqStmt.executeQuery("SELECT USER_JAVA.SEQ_PURCHASE_REQUEST.NEXTVAL FROM DUAL");
            if (rs.next()) {   
                int purchaseRequestId = rs.getInt(1);
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO USER_JAVA.PURCHASE_REQUEST(CD_PURCHASE_REQUEST,DS_PURCHASE_JUSTIFICATION,DT_REQUIRED_DATE) VALUES(?,?,?)");
                
                stmt.setLong(1, purchaseRequestId);
                stmt.setString(2, newPurchaseRequest.getDescription().toUpperCase());
                stmt.setDate(3, java.sql.Date.valueOf(newPurchaseRequest.getRequestDate()));

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    PreparedStatement productStmt = connection.prepareStatement("INSERT INTO USER_JAVA.ITPURCHASE_REQUEST(CD_PURCHASE_REQUEST, CD_PRODUCT, CD_QUANTITY_REQUESTED) VALUES(?, ?, ?)");
                    for (SelectedProduct selectedProduct : selectedProducts) {
                        productStmt.setInt(1, purchaseRequestId);
                        productStmt.setInt(2, selectedProduct.getProductId());
                        productStmt.setInt(3, selectedProduct.getQuantity());
                        productStmt.addBatch();
                    }
                    productStmt.executeBatch();

                    return new ServiceMessageReturn(false, "Solicitação de compra criada com sucesso!");
                } else {
                    return new ServiceMessageReturn(true, "Solicitação de compra não criada!");
                }
            } else {
                return new ServiceMessageReturn(true, "Solicitação de compra não criada!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ServiceMessageReturn(true, "Ocorreu um erro com o Banco de Dados!");
        }
    }
}
