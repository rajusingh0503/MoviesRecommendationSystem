<%@ page import="com.moviemind.model.User" %>
<%@ page import="com.moviemind.model.Movie" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Home - MovieMind</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<%
    User user = (User) request.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Movie> movies =
            (List<Movie>) request.getAttribute("movies");
%>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand fw-bold" href="home">
            MovieMind
        </a>

        <div>

            <span class="text-white me-3">
                Welcome, <%= user.getName() %>
            </span>

            <a href="profile" class="btn btn-outline-light btn-sm me-2">
                Profile
            </a>

            <a href="my-watchlist" class="btn btn-outline-light btn-sm me-2">
                Watchlist
            </a>

            <a href="logout" class="btn btn-danger btn-sm">
                Logout
            </a>

        </div>

    </div>

</nav>

<div class="container py-5">

    <div class="text-center mb-5">

        <h1 class="fw-bold">
            Welcome to MovieMind
        </h1>

        <p class="text-muted">
            Discover movies selected according to your preferences.
        </p>

    </div>

    <div class="card shadow-sm p-4 mb-5">

        <h3 class="mb-3">
            Get Personalized Recommendations
        </h3>

        <form action="recommendations" method="get">

            <div class="row">

                <div class="col-md-5 mb-3">

                    <label class="form-label">
                        Favorite Genre
                    </label>

                    <select name="genre" class="form-select">

                        <option value="Action">Action</option>
                        <option value="Comedy">Comedy</option>
                        <option value="Drama">Drama</option>
                        <option value="Horror">Horror</option>
                        <option value="Romance">Romance</option>
                        <option value="Sci-Fi">Sci-Fi</option>
                        <option value="Thriller">Thriller</option>

                    </select>

                </div>

                <div class="col-md-5 mb-3">

                    <label class="form-label">
                        Preferred Language
                    </label>

                    <select name="language" class="form-select">

                        <option value="English">English</option>
                        <option value="Hindi">Hindi</option>
                        <option value="Tamil">Tamil</option>
                        <option value="Telugu">Telugu</option>

                    </select>

                </div>

                <div class="col-md-2 d-flex align-items-end mb-3">

                    <button
                        type="submit"
                        class="btn btn-primary w-100">

                        Recommend

                    </button>

                </div>

            </div>

        </form>

    </div>

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2>
            Available Movies
        </h2>

        <a href="movies" class="btn btn-outline-primary">
            View All Movies
        </a>

    </div>

    <div class="row g-4">

        <%
            if (movies != null && !movies.isEmpty()) {

                for (Movie movie : movies) {
        %>

        <div class="col-md-4">

            <div class="card h-100 shadow-sm">

                <img
                    src="<%= movie.getPosterUrl() %>"
                    class="card-img-top"
                    alt="<%= movie.getTitle() %>"
                    style="height: 300px; object-fit: cover;">

                <div class="card-body">

                    <h5 class="card-title">
                        <%= movie.getTitle() %>
                    </h5>

                    <p class="text-muted mb-1">
                        <%= movie.getGenre() %>
                    </p>

                    <p class="text-muted">
                        <%= movie.getLanguage() %>
                        |
                        <%= movie.getReleaseYear() %>
                    </p>

                    <p>
                        ⭐ <%= movie.getRating() %>/5
                    </p>

                    <a
                        href="movie-details?id=<%= movie.getMovieId() %>"
                        class="btn btn-primary">

                        View Details

                    </a>

                </div>

            </div>

        </div>

        <%
                }

            } else {
        %>

        <div class="col-12">

            <div class="alert alert-info text-center">

                No movies available yet.

            </div>

        </div>

        <%
            }
        %>

    </div>

</div>

<footer class="bg-dark text-white text-center py-3">

    <p class="mb-0">
        © 2026 MovieMind - Movie Recommendation System
    </p>

</footer>

</body>
</html>