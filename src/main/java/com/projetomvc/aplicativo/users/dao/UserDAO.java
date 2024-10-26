package com.projetomvc.aplicativo.users.dao;

import java.util.List;

import com.projetomvc.aplicativo.users.model.User;

public interface UserDAO {
    List<User> getAllUsers();
}
