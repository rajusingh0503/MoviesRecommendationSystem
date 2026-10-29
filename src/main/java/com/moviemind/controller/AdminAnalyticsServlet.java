package com.moviemind.controller;

import com.moviemind.model.User;
import com.moviemind.service.AnalyticsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet("/admin-analytics")
public class AdminAnalyticsServlet extends HttpServlet {

    private AnalyticsService analyticsService;

    @Override
    public void init() {

        analyticsService =
                new AnalyticsService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null
                || session.getAttribute("user") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        User user =
                (User) session.getAttribute("user");

        if (!"ADMIN".equalsIgnoreCase(
                user.getRole())) {

            response.sendRedirect("home");
            return;
        }

        Map<String, Object> analytics =
                analyticsService.getAnalytics();

        request.setAttribute(
                "analytics",
                analytics
        );

        request.getRequestDispatcher(
                "admin-analytics.jsp"
        ).forward(request, response);
    }
}