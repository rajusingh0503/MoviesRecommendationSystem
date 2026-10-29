package com.moviemind.controller;

import com.moviemind.model.Movie;
import com.moviemind.model.Preference;
import com.moviemind.model.User;
import com.moviemind.service.MovieService;
import com.moviemind.service.PreferenceService;
import com.moviemind.recommendation.RecommendationEngine;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/recommendations")
public class RecommendationServlet extends HttpServlet {

    private MovieService movieService;
    private PreferenceService preferenceService;
    private RecommendationEngine recommendationEngine;

    @Override
    public void init() {

        movieService = new MovieService();
        preferenceService = new PreferenceService();
        recommendationEngine = new RecommendationEngine();
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

        String genre = request.getParameter("genre");
        String language = request.getParameter("language");

        Preference preference = null;

        if (genre != null && !genre.isBlank()
                && language != null && !language.isBlank()) {

            preference = new Preference();

            preference.setUserId(user.getUserId());
            preference.setGenre(genre);
            preference.setLanguage(language);

        } else {

            preference =
                    preferenceService.getLatestPreference(user.getUserId());
        }

        if (preference == null) {

            preference = new Preference();

            preference.setUserId(user.getUserId());
            preference.setGenre("Action");
            preference.setLanguage("English");
        }

        List<Movie> movies = movieService.getAllMovies();

        List<Movie> recommendations =
                recommendationEngine.generateRecommendations(
                        movies,
                        preference
                );

        request.setAttribute(
                "recommendations",
                recommendations
        );

        request.setAttribute(
                "genre",
                preference.getGenre()
        );

        request.setAttribute(
                "language",
                preference.getLanguage()
        );

        request.getRequestDispatcher(
                "recommendations.jsp"
        ).forward(request, response);
    }
}