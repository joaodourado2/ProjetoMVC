package com.projetomvc.aplicativo.product.service;

import java.sql.*;

import com.projetomvc.aplicativo.database.service.DataSourceProvider;
import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.product.model.Product;

public class CreateProductService {

    public static ServiceMessageReturn createProductService(Product newProductServ){
        
        ServiceMessageReturn serviceMessageReturn = new ServiceMessageReturn();

        String sql = "INSERT INTO USER_JAVA.PRODUCT(NM_PRODUCT,NR_PRICE,NR_WEIGHT,DS_DESCRIPTION,TP_CATEGORY,CD_EAN) " +
        "VALUES(?,?,?,?,?,?)";
        
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, newProductServ.getNameProduct());
            preparedStatement.setDouble(2, newProductServ.getPrice());
            preparedStatement.setDouble(3, newProductServ.getWeight());
            preparedStatement.setString(4, newProductServ.getDescription());
            preparedStatement.setString(5, newProductServ.getCategory());
            preparedStatement.setDouble(6, newProductServ.getEan());
        
            int countRow = preparedStatement.executeUpdate();
            
            if (countRow > 0) {
                serviceMessageReturn.setError(false);
                serviceMessageReturn.setMessageReturn("Produro inserido com Sucesso!");
                return serviceMessageReturn;
            }else{
                serviceMessageReturn.setError(true);
                serviceMessageReturn.setMessageReturn("Nenhum Registro Cadastrado!");
                return serviceMessageReturn;
            }

        }catch (SQLException e){
            serviceMessageReturn.setError(true);
            serviceMessageReturn.setMessageReturn("Ocorreu um erro com o Banco de Dados!");
            return serviceMessageReturn;
        }
    }

}
