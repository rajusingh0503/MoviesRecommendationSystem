package com.moviemind.model;

public class Preference {

    private int preferenceId;
    private int userId;
    private String genre;
    private String language;

    public Preference() {
    }

    public Preference(int preferenceId, int userId, String genre, String language) {
        this.preferenceId = preferenceId;
        this.userId = userId;
        this.genre = genre;
        this.language = language;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}