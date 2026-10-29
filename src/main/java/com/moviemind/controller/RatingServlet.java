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

@WebServlet("/rate")
public class RatingServlet extends HttpServlet {

    private RatingService ratingService;

    @Override
    public void init() {
        ratingService = new RatingService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        String movieId = request.getParameter("movieId");
        String rating = request.getParameter("rating");

        if (movieId == null || rating == null) {
            response.sendRedirect("movies?error=invalid");
            return;
        }

        try {

            int userId = user.getUserId();
            int movieIdValue = Integer.parseInt(movieId);
            double ratingValue = Double.parseDouble(rating);

            if (ratingValue < 1 || ratingValue > 5) {
                response.sendRedirect("movie-details?id=" + movieIdValue + "&error=rating");
                return;
            }

            Rating movieRating = new Rating();
            movieRating.setUserId(userId);
            movieRating.setMovieId(movieIdValue);
            movieRating.setRating(ratingValue);

            boolean success = ratingService.addRating(movieRating);

            if (success) {
                response.sendRedirect(
                        "movie-details?id=" + movieIdValue + "&rated=true"
                );
            } else {
                response.sendRedirect(
                        "movie-details?id=" + movieIdValue + "&error=rating"
                );
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("movies?error=invalid");
        }
    }
}