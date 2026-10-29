package com.moviemind.model;

public class Movie {

    private int movieId;
    private String title;
    private String description;
    private String genre;
    private String language;
    private int releaseYear;
    private double rating;
    private String posterUrl;

    public Movie() {
    }

    public Movie(int movieId, String title, String description, String genre,
                 String language, int releaseYear, double rating, String posterUrl) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.language = language;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.posterUrl = posterUrl;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}