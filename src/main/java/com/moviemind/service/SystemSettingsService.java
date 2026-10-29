package com.moviemind.service;

import com.moviemind.dao.SystemSettingsDAO;

import java.util.Map;

public class SystemSettingsService {

    private final SystemSettingsDAO systemSettingsDAO;

    public SystemSettingsService() {
        systemSettingsDAO = new SystemSettingsDAO();
    }

    public Map<String, Double> getRecommendationWeights() {
        return systemSettingsDAO.getRecommendationWeights();
    }

    public boolean updateSetting(
            String settingName,
            double settingValue) {

        return systemSettingsDAO.updateSetting(
                settingName,
                settingValue
        );
    }
}