package com.moviemind.controller;

import com.moviemind.model.Preference;
import com.moviemind.model.User;
import com.moviemind.service.PreferenceService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/preferences")
public class PreferenceServlet extends HttpServlet {

    private PreferenceService preferenceService;

    @Override
    public void init() {
        preferenceService = new PreferenceService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        String genre = request.getParameter("genre");
        String language = request.getParameter("language");

        Preference preference = new Preference();
        preference.setUserId(user.getUserId());
        preference.setGenre(genre);
        preference.setLanguage(language);

        boolean success = preferenceService.savePreference(preference);

        if (success) {
            response.sendRedirect("home?preference=saved");
        } else {
            response.sendRedirect("home?preference=failed");
        }
    }
}