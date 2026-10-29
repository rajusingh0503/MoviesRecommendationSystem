package com.moviemind.dao;

import com.moviemind.model.Movie;
import com.moviemind.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WatchlistDAO {

    public boolean addToWatchlist(
            int userId,
            int movieId) {

        String checkSql = """
                SELECT COUNT(*)
                FROM watchlist
                WHERE user_id = ?
                AND movie_id = ?
                """;

        String insertSql = """
                INSERT INTO watchlist
                (user_id, movie_id)
                VALUES (?, ?)
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement checkStatement =
                    connection.prepareStatement(checkSql)
        ) {

            checkStatement.setInt(1, userId);
            checkStatement.setInt(2, movieId);

            try (
                ResultSet resultSet =
                        checkStatement.executeQuery()
            ) {

                if (resultSet.next()
                        && resultSet.getInt(1) > 0) {

                    return false;
                }
            }

            try (
                PreparedStatement insertStatement =
                        connection.prepareStatement(insertSql)
            ) {

                insertStatement.setInt(1, userId);
                insertStatement.setInt(2, movieId);

                return insertStatement.executeUpdate() > 0;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean removeFromWatchlist(
            int userId,
            int movieId) {

        String sql = """
                DELETE FROM watchlist
                WHERE user_id = ?
                AND movie_id = ?
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);
            statement.setInt(2, movieId);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public List<Movie> getWatchlistByUserId(
            int userId) {

        List<Movie> watchlist =
                new ArrayList<>();

        String sql = """
                SELECT m.*
                FROM movies m
                INNER JOIN watchlist w
                    ON m.movie_id = w.movie_id
                WHERE w.user_id = ?
                ORDER BY w.added_at DESC
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);

            try (
                ResultSet resultSet =
                        statement.executeQuery()
            ) {

                while (resultSet.next()) {

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

                    watchlist.add(movie);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return watchlist;
    }
}