package com.projetomvc.aplicativo.users.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.projetomvc.aplicativo.database.DataSourceProvider;
import com.projetomvc.aplicativo.users.model.User;

public class UsersDao implements UserDAO {
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT CD_USER,ID_USER, NM_USER, SN_ACTIVE FROM USER_JAVA.USERS";

        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                User user = new User();
                user.setCdUser(rs.getInt("CD_USER"));
                user.setIdUser(rs.getString("ID_USER"));
                user.setNmUser(rs.getString("NM_USER"));
                user.setSnActive(rs.getString("SN_ACTIVE"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
