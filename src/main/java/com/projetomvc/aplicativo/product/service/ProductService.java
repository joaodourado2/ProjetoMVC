package com.projetomvc.aplicativo.product.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projetomvc.aplicativo.database.service.DataSourceProvider;
import com.projetomvc.aplicativo.product.model.Product;

@Service
public class ProductService {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT CD_PRODUCT, NM_PRODUCT, NR_PRICE, \r\n" + 
                        "   NR_WEIGHT, DS_DESCRIPTION, TP_CATEGORY, \r\n" + 
                        "   CD_EAN FROM USER_JAVA.PRODUCT";
                        
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getInt("CD_PRODUCT"));
                product.setNameProduct(rs.getString("NM_PRODUCT"));
                product.setPrice(rs.getDouble("NR_PRICE"));
                product.setWeight(rs.getDouble("NR_WEIGHT"));
                product.setDescription(rs.getString("DS_DESCRIPTION"));
                product.setCategory(rs.getString("TP_CATEGORY"));
                product.setEan(rs.getInt("CD_EAN"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
