package com.projetomvc.aplicativo.login.service;

import java.sql.*;

import com.projetomvc.aplicativo.database.DataSourceProvider;
import com.projetomvc.aplicativo.users.model.User;

public class ValidateLogin {

    public static boolean validateLogin(String userId, String userPass) {


        String sql = "SELECT DS_PASSWORD, SN_ACTIVE FROM USER_JAVA.USERS WHERE ID_USER = '" + userId.toUpperCase() + "'";

        User user = new User();

        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                user.setDsPassword(rs.getString("DS_PASSWORD"));
                user.setSnActive(rs.getString("SN_ACTIVE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userPass.equals(user.getDsPassword()) && ("S").equals(user.getSnActive())) {
            return true;
        }

        return false;

    }

}
