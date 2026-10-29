package com.moviemind.controller;

import com.moviemind.model.Movie;
import com.moviemind.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/movie-details")
public class MovieDetailsServlet extends HttpServlet {

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

        String movieIdParameter =
                request.getParameter("id");

        if (movieIdParameter == null
                || movieIdParameter.isBlank()) {

            response.sendRedirect("movies?error=invalid");
            return;
        }

        try {

            int movieId =
                    Integer.parseInt(movieIdParameter);

            Movie movie =
                    movieService.getMovieById(movieId);

            if (movie == null) {

                response.sendRedirect(
                        "movies?error=notfound"
                );

                return;
            }

            request.setAttribute(
                    "movie",
                    movie
            );

            request.getRequestDispatcher(
                    "movie-details.jsp"
            ).forward(request, response);

        } catch (NumberFormatException e) {

            response.sendRedirect(
                    "movies?error=invalid"
            );
        }
    }
}