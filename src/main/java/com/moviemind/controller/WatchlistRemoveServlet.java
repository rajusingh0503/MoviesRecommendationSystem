package com.moviemind.controller;

import com.moviemind.model.User;
import com.moviemind.service.WatchlistService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/remove-watchlist")
public class WatchlistRemoveServlet extends HttpServlet {

    private WatchlistService watchlistService;

    @Override
    public void init() {
        watchlistService = new WatchlistService();
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        String movieIdParameter =
                request.getParameter("movieId");

        if (movieIdParameter == null
                || movieIdParameter.isBlank()) {

            response.sendRedirect("watchlist?error=invalid");
            return;
        }

        try {

            int movieId =
                    Integer.parseInt(movieIdParameter);

            boolean success =
                    watchlistService.removeFromWatchlist(
                            user.getUserId(),
                            movieId
                    );

            if (success) {

                response.sendRedirect(
                        "watchlist?removed=true"
                );

            } else {

                response.sendRedirect(
                        "watchlist?error=remove"
                );
            }

        } catch (NumberFormatException e) {

            response.sendRedirect(
                    "watchlist?error=invalid"
            );
        }
    }
}