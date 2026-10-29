package com.moviemind.dao;

import com.moviemind.model.Movie;
import com.moviemind.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM movies";

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery()
        ) {

            while (resultSet.next()) {

                movies.add(mapMovie(resultSet));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return movies;
    }

    public Movie getMovieById(int movieId) {

        String sql = """
                SELECT *
                FROM movies
                WHERE movie_id = ?
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setInt(1, movieId);

            try (
                ResultSet resultSet =
                        statement.executeQuery()
            ) {

                if (resultSet.next()) {

                    return mapMovie(resultSet);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    public boolean addMovie(Movie movie) {

        String sql = """
                INSERT INTO movies
                (title, description, genre, language,
                 release_year, rating, poster_url)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    movie.getTitle()
            );

            statement.setString(
                    2,
                    movie.getDescription()
            );

            statement.setString(
                    3,
                    movie.getGenre()
            );

            statement.setString(
                    4,
                    movie.getLanguage()
            );

            statement.setInt(
                    5,
                    movie.getReleaseYear()
            );

            statement.setDouble(
                    6,
                    movie.getRating()
            );

            statement.setString(
                    7,
                    movie.getPosterUrl()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean updateMovie(Movie movie) {

        String sql = """
                UPDATE movies
                SET title = ?,
                    description = ?,
                    genre = ?,
                    language = ?,
                    release_year = ?,
                    rating = ?,
                    poster_url = ?
                WHERE movie_id = ?
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    movie.getTitle()
            );

            statement.setString(
                    2,
                    movie.getDescription()
            );

            statement.setString(
                    3,
                    movie.getGenre()
            );

            statement.setString(
                    4,
                    movie.getLanguage()
            );

            statement.setInt(
                    5,
                    movie.getReleaseYear()
            );

            statement.setDouble(
                    6,
                    movie.getRating()
            );

            statement.setString(
                    7,
                    movie.getPosterUrl()
            );

            statement.setInt(
                    8,
                    movie.getMovieId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteMovie(int movieId) {

        String sql = """
                DELETE FROM movies
                WHERE movie_id = ?
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    movieId
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    private Movie mapMovie(
            ResultSet resultSet)
            throws SQLException {

        Movie movie = new Movie();

        movie.setMovieId(
                resultSet.getInt("movie_id")
        );

        movie.setTitle(
                resultSet.getString("title")
        );

        movie.setDescription(
                resultSet.getString("description")
        );

        movie.setGenre(
                resultSet.getString("genre")
        );

        movie.setLanguage(
                resultSet.getString("language")
        );

        movie.setReleaseYear(
                resultSet.getInt("release_year")
        );

        movie.setRating(
                resultSet.getDouble("rating")
        );

        movie.setPosterUrl(
                resultSet.getString("poster_url")
        );

        return movie;
    }
}