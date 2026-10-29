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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        if (email == null
                || email.isBlank()
                || password == null
                || password.isBlank()) {

            response.sendRedirect(
                    "login.jsp?error=empty"
            );

            return;
        }

        User user =
                userService.login(
                        email,
                        password
                );

        if (user != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "user",
                    user
            );

            if ("ADMIN".equalsIgnoreCase(
                    user.getRole())) {

                response.sendRedirect(
                        "admin-dashboard"
                );

            } else {

                response.sendRedirect(
                        "home"
                );
            }

        } else {

            response.sendRedirect(
                    "login.jsp?error=invalid"
            );
        }
    }
}