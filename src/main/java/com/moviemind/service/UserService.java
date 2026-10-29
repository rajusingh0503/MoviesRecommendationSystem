package com.moviemind.service;

import com.moviemind.dao.UserDAO;
import com.moviemind.model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User login(String email, String password) {
        return userDAO.login(email, password);
    }

    public boolean register(User user) {
        return userDAO.register(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}