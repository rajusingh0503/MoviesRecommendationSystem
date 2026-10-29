package com.moviemind.controller;

import com.moviemind.model.User;
import com.moviemind.service.SystemSettingsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin-settings")
public class AdminSettingsServlet extends HttpServlet {

    private SystemSettingsService systemSettingsService;

    @Override
    public void init() {
        systemSettingsService =
                new SystemSettingsService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null
                || session.getAttribute("user") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        User user =
                (User) session.getAttribute("user");

        if (!"ADMIN".equalsIgnoreCase(
                user.getRole())) {

            response.sendRedirect("home");
            return;
        }

        request.setAttribute(
                "weights",
                systemSettingsService
                        .getRecommendationWeights()
        );

        request.getRequestDispatcher(
                "admin-settings.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null
                || session.getAttribute("user") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        User user =
                (User) session.getAttribute("user");

        if (!"ADMIN".equalsIgnoreCase(
                user.getRole())) {

            response.sendRedirect("home");
            return;
        }

        try {

            double genreWeight =
                    Double.parseDouble(
                            request.getParameter(
                                    "genreWeight"
                            )
                    );

            double ratingWeight =
                    Double.parseDouble(
                            request.getParameter(
                                    "ratingWeight"
                            )
                    );

            double behaviorWeight =
                    Double.parseDouble(
                            request.getParameter(
                                    "behaviorWeight"
                            )
                    );

            double popularityWeight =
                    Double.parseDouble(
                            request.getParameter(
                                    "popularityWeight"
                            )
                    );

            double total =
                    genreWeight
                    + ratingWeight
                    + behaviorWeight
                    + popularityWeight;

            if (genreWeight < 0
                    || ratingWeight < 0
                    || behaviorWeight < 0
                    || popularityWeight < 0
                    || Math.abs(total - 1.0) > 0.001) {

                response.sendRedirect(
                        "admin-settings?error=weights"
                );

                return;
            }

            boolean genreUpdated =
                    systemSettingsService.updateSetting(
                            "genre_weight",
                            genreWeight
                    );

            boolean ratingUpdated =
                    systemSettingsService.updateSetting(
                            "rating_weight",
                            ratingWeight
                    );

            boolean behaviorUpdated =
                    systemSettingsService.updateSetting(
                            "behavior_weight",
                            behaviorWeight
                    );

            boolean popularityUpdated =
                    systemSettingsService.updateSetting(
                            "popularity_weight",
                            popularityWeight
                    );

            if (genreUpdated
                    && ratingUpdated
                    && behaviorUpdated
                    && popularityUpdated) {

                response.sendRedirect(
                        "admin-settings?saved=true"
                );

            } else {

                response.sendRedirect(
                        "admin-settings?error=save"
                );
            }

        } catch (NumberFormatException e) {

            response.sendRedirect(
                    "admin-settings?error=invalid"
            );
        }
    }
}