package com.moviemind.dao;

import com.moviemind.model.Preference;
import com.moviemind.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreferenceDAO {

    public boolean savePreference(Preference preference) {

        String sql = """
                INSERT INTO user_preferences
                (user_id, genre, language)
                VALUES (?, ?, ?)
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, preference.getUserId());
            statement.setString(2, preference.getGenre());
            statement.setString(3, preference.getLanguage());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Preference getLatestPreference(int userId) {

        String sql = """
                SELECT *
                FROM user_preferences
                WHERE user_id = ?
                ORDER BY preference_id DESC
                LIMIT 1
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Preference preference = new Preference();

                    preference.setPreferenceId(
                            resultSet.getInt("preference_id")
                    );

                    preference.setUserId(
                            resultSet.getInt("user_id")
                    );

                    preference.setGenre(
                            resultSet.getString("genre")
                    );

                    preference.setLanguage(
                            resultSet.getString("language")
                    );

                    return preference;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}