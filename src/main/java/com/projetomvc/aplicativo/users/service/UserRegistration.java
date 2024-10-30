package com.projetomvc.aplicativo.users.service;

import java.sql.*;

import com.projetomvc.aplicativo.database.DataSourceProvider;
import com.projetomvc.aplicativo.users.model.User;

public class UserRegistration {

    public static boolean userRegistration(User newUser){

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
                return true;
            }else{
                return false;
            } 
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
