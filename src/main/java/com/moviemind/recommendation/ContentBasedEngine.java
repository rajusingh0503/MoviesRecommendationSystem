package com.moviemind.recommendation;

import com.moviemind.model.Movie;
import com.moviemind.model.Preference;

import java.util.ArrayList;
import java.util.List;

public class ContentBasedEngine {

    public List<Movie> getMatchingMovies(
            List<Movie> movies,
            Preference preference) {

        List<Movie> matchingMovies = new ArrayList<>();

        if (movies == null || preference == null) {
            return matchingMovies;
        }

        for (Movie movie : movies) {

            if (movie == null) {
                continue;
            }

            boolean genreMatch =
                    movie.getGenre() != null
                    && preference.getGenre() != null
                    && movie.getGenre()
                            .equalsIgnoreCase(
                                    preference.getGenre()
                            );

            boolean languageMatch =
                    movie.getLanguage() != null
                    && preference.getLanguage() != null
                    && movie.getLanguage()
                            .equalsIgnoreCase(
                                    preference.getLanguage()
                            );

            if (genreMatch || languageMatch) {
                matchingMovies.add(movie);
            }
        }

        return matchingMovies;
    }
}