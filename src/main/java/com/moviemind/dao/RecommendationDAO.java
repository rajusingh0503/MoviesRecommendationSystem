package com.moviemind.dao;

import com.moviemind.model.Recommendation;
import com.moviemind.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecommendationDAO {

    public boolean saveRecommendation(Recommendation recommendation) {

        String sql = "INSERT INTO recommendations (user_id, movie_id, score) VALUES (?, ?, ?)";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, recommendation.getUserId());
            statement.setInt(2, recommendation.getMovieId());
            statement.setDouble(3, recommendation.getScore());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}