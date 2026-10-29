package com.moviemind.service;

import com.moviemind.dao.RatingDAO;
import com.moviemind.model.Rating;

import java.util.List;

public class RatingService {

    private final RatingDAO ratingDAO;

    public RatingService() {
        ratingDAO = new RatingDAO();
    }

    public boolean addRating(Rating rating) {
        return ratingDAO.addRating(rating);
    }

    public List<Rating> getRatingsByUserId(int userId) {
        return ratingDAO.getRatingsByUserId(userId);
    }
}