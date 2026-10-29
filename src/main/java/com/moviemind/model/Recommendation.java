package com.moviemind.model;

public class Recommendation {

    private int recommendationId;
    private int userId;
    private int movieId;
    private double score;

    public Recommendation() {
    }

    public Recommendation(int recommendationId, int userId, int movieId, double score) {
        this.recommendationId = recommendationId;
        this.userId = userId;
        this.movieId = movieId;
        this.score = score;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(int recommendationId) {
        this.recommendationId = recommendationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}