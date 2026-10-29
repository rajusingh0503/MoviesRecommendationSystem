package com.moviemind.dao;

import com.moviemind.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsDAO {

    public Map<String, Object> getAnalytics() {

        Map<String, Object> analytics =
                new HashMap<>();

        String userSql =
                "SELECT COUNT(*) FROM users";

        String movieSql =
                "SELECT COUNT(*) FROM movies";

        String ratingSql =
                "SELECT COUNT(*) FROM ratings";

        String watchlistSql =
                "SELECT COUNT(*) FROM watchlist";

        String recommendationSql =
                "SELECT COUNT(*) FROM recommendations";

        try (
            Connection connection =
                    DatabaseConnection.getConnection()
        ) {

            analytics.put(
                    "totalUsers",
                    getCount(connection, userSql)
            );

            analytics.put(
                    "totalMovies",
                    getCount(connection, movieSql)
            );

            analytics.put(
                    "totalRatings",
                    getCount(connection, ratingSql)
            );

            analytics.put(
                    "totalWatchlist",
                    getCount(connection, watchlistSql)
            );

            analytics.put(
                    "totalRecommendations",
                    getCount(connection, recommendationSql)
            );

        } catch (Exception e) {

            e.printStackTrace();

            analytics.put("totalUsers", 0);
            analytics.put("totalMovies", 0);
            analytics.put("totalRatings", 0);
            analytics.put("totalWatchlist", 0);
            analytics.put("totalRecommendations", 0);
        }

        return analytics;
    }

    private int getCount(
            Connection connection,
            String sql) throws Exception {

        try (
            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery()
        ) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }

        return 0;
    }
}