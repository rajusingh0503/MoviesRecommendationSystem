package com.moviemind.controller;

import com.moviemind.model.Rating;
import com.moviemind.model.User;
import com.moviemind.service.RatingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/rating-history")
public class RatingHistoryServlet extends HttpServlet {

    private RatingService ratingService;

    @Override
    public void init() {
        ratingService = new RatingService();
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

        User user = (User) session.getAttribute("user");

        int userId = user.getUserId();

        List<Rating> ratings =
                ratingService.getRatingsByUserId(userId);

        request.setAttribute("ratings", ratings);

        request.getRequestDispatcher("rating-history.jsp")
                .forward(request, response);
    }
}