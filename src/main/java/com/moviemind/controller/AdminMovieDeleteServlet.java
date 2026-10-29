package com.moviemind.controller;

import com.moviemind.model.User;
import com.moviemind.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin-movie-delete")
public class AdminMovieDeleteServlet extends HttpServlet {

    private MovieService movieService;

    @Override
    public void init() {
        movieService = new MovieService();
    }

    @Override
    protected void doPost(
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

        String movieIdParameter =
                request.getParameter("movieId");

        if (movieIdParameter == null
                || movieIdParameter.isBlank()) {

            response.sendRedirect(
                    "admin-movies?error=invalid"
            );

            return;
        }

        try {

            int movieId =
                    Integer.parseInt(movieIdParameter);

            boolean success =
                    movieService.deleteMovie(movieId);

            if (success) {

                response.sendRedirect(
                        "admin-movies?deleted=true"
                );

            } else {

                response.sendRedirect(
                        "admin-movies?error=delete"
                );
            }

        } catch (NumberFormatException e) {

            response.sendRedirect(
                    "admin-movies?error=invalid"
            );
        }
    }
}