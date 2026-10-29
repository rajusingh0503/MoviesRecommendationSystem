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

@WebServlet("/admin-movie-add")
public class AdminMovieAddServlet extends HttpServlet {

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

        try {

            String title =
                    request.getParameter("title");

            String description =
                    request.getParameter("description");

            String genre =
                    request.getParameter("genre");

            String language =
                    request.getParameter("language");

            int releaseYear =
                    Integer.parseInt(
                            request.getParameter(
                                    "releaseYear"
                            )
                    );

            double rating =
                    Double.parseDouble(
                            request.getParameter(
                                    "rating"
                            )
                    );

            String posterUrl =
                    request.getParameter("posterUrl");

            if (title == null
                    || title.isBlank()
                    || genre == null
                    || genre.isBlank()
                    || language == null
                    || language.isBlank()) {

                response.sendRedirect(
                        "admin-movies?error=invalid"
                );

                return;
            }

            if (rating < 0 || rating > 5) {

                response.sendRedirect(
                        "admin-movies?error=rating"
                );

                return;
            }

            Movie movie = new Movie();

            movie.setTitle(title);
            movie.setDescription(description);
            movie.setGenre(genre);
            movie.setLanguage(language);
            movie.setReleaseYear(releaseYear);
            movie.setRating(rating);
            movie.setPosterUrl(posterUrl);

            boolean success =
                    movieService.addMovie(movie);

            if (success) {

                response.sendRedirect(
                        "admin-movies?added=true"
                );

            } else {

                response.sendRedirect(
                        "admin-movies?error=add"
                );
            }

        } catch (NumberFormatException e) {

            response.sendRedirect(
                    "admin-movies?error=invalid"
            );
        }
    }
}