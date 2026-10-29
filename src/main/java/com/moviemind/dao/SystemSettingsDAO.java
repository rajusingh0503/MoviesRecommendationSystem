package com.moviemind.dao;

import com.moviemind.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SystemSettingsDAO {

    public Map<String, Double> getRecommendationWeights() {

        Map<String, Double> weights = new HashMap<>();

        String sql = """
                SELECT setting_name, setting_value
                FROM system_settings
                WHERE setting_name IN (
                    'genre_weight',
                    'rating_weight',
                    'behavior_weight',
                    'popularity_weight'
                )
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                String name =
                        resultSet.getString("setting_name");

                double value =
                        Double.parseDouble(
                                resultSet.getString("setting_value")
                        );

                weights.put(name, value);
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }

        return weights;
    }

    public boolean updateSetting(
            String settingName,
            double settingValue) {

        String sql = """
                INSERT INTO system_settings
                (setting_name, setting_value)
                VALUES (?, ?)
                ON DUPLICATE KEY UPDATE
                setting_value = VALUES(setting_value)
                """;

        try (
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setString(1, settingName);
            statement.setString(
                    2,
                    String.valueOf(settingValue)
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}