package com.moviemind.controller;

import com.moviemind.model.Movie;
import com.moviemind.model.User;
import com.moviemind.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private MovieService movieService;

    @Override
    public void init() {
        movieService = new MovieService();
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

        List<Movie> movies =
                movieService.getAllMovies();

        request.setAttribute(
                "movies",
                movies
        );

        request.setAttribute(
                "user",
                user
        );

        request.getRequestDispatcher(
                "home.jsp"
        ).forward(request, response);
    }
}