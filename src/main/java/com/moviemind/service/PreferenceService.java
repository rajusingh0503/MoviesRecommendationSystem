package com.moviemind.service;

import com.moviemind.dao.PreferenceDAO;
import com.moviemind.model.Preference;

public class PreferenceService {

    private final PreferenceDAO preferenceDAO;

    public PreferenceService() {
        preferenceDAO = new PreferenceDAO();
    }

    public boolean savePreference(Preference preference) {
        return preferenceDAO.savePreference(preference);
    }

    public Preference getLatestPreference(int userId) {
        return preferenceDAO.getLatestPreference(userId);
    }
}