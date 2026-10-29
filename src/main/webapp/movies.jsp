<%@ page import="com.moviemind.model.Movie" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Movies - MovieMind</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand fw-bold" href="home">
            MovieMind
        </a>

        <div>

            <a href="home" class="btn btn-outline-light btn-sm me-2">
                Home
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
            Explore Movies
        </h1>

        <p class="text-muted">
            Browse all available movies on MovieMind.
        </p>

    </div>

    <%
        List<Movie> movies =
                (List<Movie>) request.getAttribute("movies");
    %>

    <div class="row g-4">

        <%
            if (movies != null && !movies.isEmpty()) {

                for (Movie movie : movies) {
        %>

        <div class="col-md-4 col-lg-3">

            <div class="card h-100 shadow-sm">

                <img
                    src="<%= movie.getPosterUrl() %>"
                    class="card-img-top"
                    alt="<%= movie.getTitle() %>"
                    style="height: 320px; object-fit: cover;">

                <div class="card-body d-flex flex-column">

                    <h5 class="card-title">
                        <%= movie.getTitle() %>
                    </h5>

                    <p class="text-muted mb-1">
                        Genre: <%= movie.getGenre() %>
                    </p>

                    <p class="text-muted mb-1">
                        Language: <%= movie.getLanguage() %>
                    </p>

                    <p class="text-muted mb-2">
                        Year: <%= movie.getReleaseYear() %>
                    </p>

                    <p>
                        ⭐ <%= movie.getRating() %>/5
                    </p>

                    <div class="mt-auto">

                        <a
                            href="movie-details?id=<%= movie.getMovieId() %>"
                            class="btn btn-primary w-100 mb-2">

                            View Details

                        </a>

                        <form action="watchlist" method="post">

                            <input
                                type="hidden"
                                name="movieId"
                                value="<%= movie.getMovieId() %>">

                            <button
                                type="submit"
                                class="btn btn-outline-success w-100">

                                Add to Watchlist

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        </div>

        <%
                }

            } else {
        %>

        <div class="col-12">

            <div class="alert alert-info text-center">

                No movies available in the database.

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