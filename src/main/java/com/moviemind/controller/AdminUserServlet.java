package com.moviemind.controller;

import com.moviemind.model.User;
import com.moviemind.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin-users")
public class AdminUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User admin = (User) session.getAttribute("user");

        if (!"ADMIN".equalsIgnoreCase(admin.getRole())) {
            response.sendRedirect("home.jsp");
            return;
        }

        List<User> users = userService.getAllUsers();

        request.setAttribute("users", users);

        request.getRequestDispatcher("admin-users.jsp")
                .forward(request, response);
    }
}