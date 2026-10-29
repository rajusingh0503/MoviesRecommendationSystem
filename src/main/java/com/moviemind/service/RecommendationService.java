package com.moviemind.service;

import com.moviemind.dao.RecommendationDAO;
import com.moviemind.model.Recommendation;

public class RecommendationService {

    private final RecommendationDAO recommendationDAO;

    public RecommendationService() {
        recommendationDAO = new RecommendationDAO();
    }

    public boolean saveRecommendation(Recommendation recommendation) {
        return recommendationDAO.saveRecommendation(recommendation);
    }
}