package com.moviemind.service;

import com.moviemind.dao.MovieDAO;
import com.moviemind.model.Movie;

import java.util.List;

public class MovieService {

    private final MovieDAO movieDAO;

    public MovieService() {
        movieDAO = new MovieDAO();
    }

    public List<Movie> getAllMovies() {

        return movieDAO.getAllMovies();
    }

    public Movie getMovieById(int movieId) {

        return movieDAO.getMovieById(movieId);
    }

    public boolean addMovie(Movie movie) {

        return movieDAO.addMovie(movie);
    }

    public boolean updateMovie(Movie movie) {

        return movieDAO.updateMovie(movie);
    }

    public boolean deleteMovie(int movieId) {

        return movieDAO.deleteMovie(movieId);
    }
}