package com.moviemind.service;

import com.moviemind.dao.AnalyticsDAO;

import java.util.Map;

public class AnalyticsService {

    private final AnalyticsDAO analyticsDAO;

    public AnalyticsService() {
        analyticsDAO = new AnalyticsDAO();
    }

    public Map<String, Object> getAnalytics() {

        return analyticsDAO.getAnalytics();
    }
}