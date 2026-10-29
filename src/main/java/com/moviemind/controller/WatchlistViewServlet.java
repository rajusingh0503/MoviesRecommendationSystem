package com.moviemind.controller;

import com.moviemind.model.Movie;
import com.moviemind.model.User;
import com.moviemind.service.WatchlistService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/watchlist")
public class WatchlistViewServlet extends HttpServlet {

    private WatchlistService watchlistService;

    @Override
    public void init() {
        watchlistService = new WatchlistService();
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

        List<Movie> watchlist =
                watchlistService.getWatchlistByUserId(userId);

        request.setAttribute("watchlist", watchlist);

        request.getRequestDispatcher("watchlist.jsp")
                .forward(request, response);
    }
}