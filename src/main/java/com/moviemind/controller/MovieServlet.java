package com.moviemind.controller;

import com.moviemind.model.Movie;
import com.moviemind.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/movies")
public class MovieServlet extends HttpServlet {

    private MovieService movieService;

    @Override
    public void init() {
        movieService = new MovieService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Movie> movies = movieService.getAllMovies();

        request.setAttribute("movies", movies);

        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }
}