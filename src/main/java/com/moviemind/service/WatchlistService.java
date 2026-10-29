package com.moviemind.service;

import com.moviemind.dao.WatchlistDAO;
import com.moviemind.model.Movie;

import java.util.List;

public class WatchlistService {

    private final WatchlistDAO watchlistDAO;

    public WatchlistService() {
        watchlistDAO = new WatchlistDAO();
    }

    public boolean addToWatchlist(
            int userId,
            int movieId) {

        return watchlistDAO.addToWatchlist(
                userId,
                movieId
        );
    }

    public boolean removeFromWatchlist(
            int userId,
            int movieId) {

        return watchlistDAO.removeFromWatchlist(
                userId,
                movieId
        );
    }

    public List<Movie> getWatchlistByUserId(
            int userId) {

        return watchlistDAO.getWatchlistByUserId(
                userId
        );
    }
}