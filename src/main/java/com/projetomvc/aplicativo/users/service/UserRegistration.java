package com.projetomvc.aplicativo.users.service;

import java.sql.*;

import com.projetomvc.aplicativo.database.service.DataSourceProvider;
import com.projetomvc.aplicativo.global.model.ServiceMessageReturn;
import com.projetomvc.aplicativo.users.model.User;

public class UserRegistration {

    public static ServiceMessageReturn userRegistration(User newUser){

        String sql = "INSERT INTO USER_JAVA.USERS(ID_USER,NM_USER,DS_PASSWORD,SN_ACTIVE)"+
                     "VALUES(?,?,?,?)";
        
        try(Connection connection = DataSourceProvider.getDataSource().getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,newUser.getIdUser().toUpperCase());
            stmt.setString(2,newUser.getNmUser().toUpperCase());
            stmt.setString(3,newUser.getDsPassword());
            stmt.setString(4,"S");

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return new ServiceMessageReturn(false,"Usuário Cadastrado com Sucesso!");
            }else{
                return new ServiceMessageReturn(true,"Usuário não cadastrado!");
            } 
        }catch (SQLException e) {
            e.printStackTrace();
            return new ServiceMessageReturn(true,"Ocorreu um erro com o Banco de Dados!");
        }

    }

}
