package com.moviemind.dao;

import com.moviemind.model.Rating;
import com.moviemind.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO {

    public boolean addRating(Rating rating) {

        String sql = """
                INSERT INTO ratings
                (user_id, movie_id, rating)
                VALUES (?, ?, ?)
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, rating.getUserId());
            statement.setInt(2, rating.getMovieId());
            statement.setDouble(3, rating.getRating());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Rating> getRatingsByUserId(int userId) {

        List<Rating> ratings = new ArrayList<>();

        String sql = """
                SELECT *
                FROM ratings
                WHERE user_id = ?
                ORDER BY rating_id DESC
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    Rating rating = new Rating();

                    rating.setRatingId(
                            resultSet.getInt("rating_id")
                    );

                    rating.setUserId(
                            resultSet.getInt("user_id")
                    );

                    rating.setMovieId(
                            resultSet.getInt("movie_id")
                    );

                    rating.setRating(
                            resultSet.getDouble("rating")
                    );

                    ratings.add(rating);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratings;
    }
}