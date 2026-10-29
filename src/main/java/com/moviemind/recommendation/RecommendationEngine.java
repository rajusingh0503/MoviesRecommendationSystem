package com.moviemind.recommendation;

import com.moviemind.model.Movie;
import com.moviemind.model.Preference;
import com.moviemind.service.SystemSettingsService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationEngine {

    private final SystemSettingsService systemSettingsService;

    public RecommendationEngine() {
        systemSettingsService = new SystemSettingsService();
    }

    public List<Movie> generateRecommendations(
            List<Movie> movies,
            Preference preference) {

        List<MovieScore> scoredMovies = new ArrayList<>();

        if (movies == null || preference == null) {
            return new ArrayList<>();
        }

        Map<String, Double> weights =
                systemSettingsService.getRecommendationWeights();

        double genreWeight =
                weights.getOrDefault("genre_weight", 0.40);

        double ratingWeight =
                weights.getOrDefault("rating_weight", 0.25);

        double behaviorWeight =
                weights.getOrDefault("behavior_weight", 0.20);

        double popularityWeight =
                weights.getOrDefault("popularity_weight", 0.15);

        for (Movie movie : movies) {

            double genreScore = calculateGenreScore(
                    movie,
                    preference
            );

            double ratingScore = calculateRatingScore(movie);

            double behaviorScore = calculateBehaviorScore(
                    movie,
                    preference
            );

            double popularityScore = calculatePopularityScore(movie);

            double finalScore =
                    (genreScore * genreWeight)
                    + (ratingScore * ratingWeight)
                    + (behaviorScore * behaviorWeight)
                    + (popularityScore * popularityWeight);

            if (finalScore > 0) {

                scoredMovies.add(
                        new MovieScore(movie, finalScore)
                );
            }
        }

        scoredMovies.sort(
                Comparator.comparingDouble(
                        MovieScore::getScore
                ).reversed()
        );

        List<Movie> recommendations =
                new ArrayList<>();

        for (MovieScore movieScore : scoredMovies) {

            recommendations.add(
                    movieScore.getMovie()
            );
        }

        return recommendations;
    }

    private double calculateGenreScore(
            Movie movie,
            Preference preference) {

        if (movie.getGenre() == null
                || preference.getGenre() == null) {

            return 0.0;
        }

        return movie.getGenre()
                .equalsIgnoreCase(preference.getGenre())
                ? 1.0
                : 0.0;
    }

    private double calculateRatingScore(Movie movie) {

        double rating = movie.getRating();

        if (rating < 0) {
            return 0.0;
        }

        if (rating > 5) {
            rating = 5;
        }

        return rating / 5.0;
    }

    private double calculateBehaviorScore(
            Movie movie,
            Preference preference) {

        if (movie.getLanguage() == null
                || preference.getLanguage() == null) {

            return 0.0;
        }

        return movie.getLanguage()
                .equalsIgnoreCase(preference.getLanguage())
                ? 1.0
                : 0.0;
    }

    private double calculatePopularityScore(Movie movie) {

        double rating = movie.getRating();

        if (rating < 0) {
            return 0.0;
        }

        if (rating > 5) {
            rating = 5;
        }

        return rating / 5.0;
    }

    private static class MovieScore {

        private final Movie movie;
        private final double score;

        public MovieScore(
                Movie movie,
                double score) {

            this.movie = movie;
            this.score = score;
        }

        public Movie getMovie() {
            return movie;
        }

        public double getScore() {
            return score;
        }
    }
}