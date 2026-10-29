<%@ page import="java.util.Map" %>

<%
    Map<String, Object> analytics =
            (Map<String, Object>) request.getAttribute("analytics");

    int totalUsers =
            analytics != null
            ? (Integer) analytics.getOrDefault("totalUsers", 0)
            : 0;

    int totalMovies =
            analytics != null
            ? (Integer) analytics.getOrDefault("totalMovies", 0)
            : 0;

    int totalRatings =
            analytics != null
            ? (Integer) analytics.getOrDefault("totalRatings", 0)
            : 0;

    int totalWatchlist =
            analytics != null
            ? (Integer) analytics.getOrDefault("totalWatchlist", 0)
            : 0;

    int totalRecommendations =
            analytics != null
            ? (Integer) analytics.getOrDefault(
                    "totalRecommendations", 0)
            : 0;
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Analytics - MovieMind</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand fw-bold"
           href="admin-dashboard">
            MovieMind Admin
        </a>

        <div>

            <a href="admin-dashboard"
               class="btn btn-outline-light me-2">
                Dashboard
            </a>

            <a href="logout"
               class="btn btn-danger">
                Logout
            </a>

        </div>

    </div>

</nav>

<div class="container py-5">

    <div class="mb-4">

        <h2 class="fw-bold">
            Recommendation Analytics
        </h2>

        <p class="text-muted">
            Real-time statistics collected from the
            MovieMind database.
        </p>

    </div>

    <div class="row g-4">

        <div class="col-md-6 col-lg-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h5 class="text-muted">
                        Total Users
                    </h5>

                    <h2 class="fw-bold mt-3">
                        <%= totalUsers %>
                    </h2>

                    <p class="text-muted mb-0">
                        Registered users
                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-6 col-lg-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h5 class="text-muted">
                        Total Movies
                    </h5>

                    <h2 class="fw-bold mt-3">
                        <%= totalMovies %>
                    </h2>

                    <p class="text-muted mb-0">
                        Movies available
                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-6 col-lg-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h5 class="text-muted">
                        Total Ratings
                    </h5>

                    <h2 class="fw-bold mt-3">
                        <%= totalRatings %>
                    </h2>

                    <p class="text-muted mb-0">
                        User ratings
                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-6 col-lg-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h5 class="text-muted">
                        Watchlist Items
                    </h5>

                    <h2 class="fw-bold mt-3">
                        <%= totalWatchlist %>
                    </h2>

                    <p class="text-muted mb-0">
                        Saved movies
                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-6 col-lg-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h5 class="text-muted">
                        Recommendations
                    </h5>

                    <h2 class="fw-bold mt-3">
                        <%= totalRecommendations %>
                    </h2>

                    <p class="text-muted mb-0">
                        Generated recommendations
                    </p>

                </div>

            </div>

        </div>

    </div>

    <div class="card shadow-sm mt-5">

        <div class="card-body">

            <h4 class="mb-3">
                Recommendation System Status
            </h4>

            <div class="alert alert-success mb-0">

                <strong>System Active</strong>

                <br>

                MovieMind is collecting user activity
                and generating personalized movie
                recommendations.

            </div>

        </div>

    </div>

</div>

<footer class="bg-dark text-white text-center py-3">

    <p class="mb-0">
        © 2026 MovieMind - Admin Analytics
    </p>

</footer>

</body>

</html>