<%@ page import="com.moviemind.model.Movie" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Movie Details - MovieMind</title>

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

            <a href="movies" class="btn btn-outline-light btn-sm me-2">
                Movies
            </a>

            <a href="my-watchlist" class="btn btn-outline-light btn-sm">
                Watchlist
            </a>

        </div>

    </div>

</nav>

<div class="container py-5">

<%
    Movie movie = (Movie) request.getAttribute("movie");

    if (movie != null) {
%>

    <div class="row justify-content-center">

        <div class="col-md-5">

            <img
                src="<%= movie.getPosterUrl() %>"
                alt="<%= movie.getTitle() %>"
                class="img-fluid rounded shadow"
                style="width: 100%; max-height: 600px; object-fit: cover;">

        </div>

        <div class="col-md-6 mt-4 mt-md-0">

            <h1 class="fw-bold">
                <%= movie.getTitle() %>
            </h1>

            <div class="mb-3">

                <span class="badge bg-primary me-2">
                    <%= movie.getGenre() %>
                </span>

                <span class="badge bg-secondary">
                    <%= movie.getLanguage() %>
                </span>

            </div>

            <p class="text-muted">
                Release Year:
                <strong>
                    <%= movie.getReleaseYear() %>
                </strong>
            </p>

            <p>
                ⭐
                <strong>
                    <%= movie.getRating() %>/5
                </strong>
            </p>

            <hr>

            <h4>
                Description
            </h4>

            <p class="text-muted">
                <%= movie.getDescription() %>
            </p>

            <div class="mt-4">

                <form action="watchlist" method="post" class="d-inline">

                    <input
                        type="hidden"
                        name="movieId"
                        value="<%= movie.getMovieId() %>">

                    <button
                        type="submit"
                        class="btn btn-success me-2">

                        Add to Watchlist

                    </button>

                </form>

                <a
                    href="movies"
                    class="btn btn-outline-primary">

                    Back to Movies

                </a>

            </div>

            <div class="card shadow-sm mt-5">

                <div class="card-body">

                    <h4 class="mb-3">
                        Rate This Movie
                    </h4>

                    <form action="rate" method="post">

                        <input
                            type="hidden"
                            name="movieId"
                            value="<%= movie.getMovieId() %>">

                        <div class="mb-3">

                            <label class="form-label">
                                Your Rating
                            </label>

                            <select
                                name="rating"
                                class="form-select"
                                required>

                                <option value="">
                                    Select Rating
                                </option>

                                <option value="1">
                                    1 - Poor
                                </option>

                                <option value="2">
                                    2 - Below Average
                                </option>

                                <option value="3">
                                    3 - Average
                                </option>

                                <option value="4">
                                    4 - Good
                                </option>

                                <option value="5">
                                    5 - Excellent
                                </option>

                            </select>

                        </div>

                        <button
                            type="submit"
                            class="btn btn-primary">

                            Submit Rating

                        </button>

                    </form>

                    <%
                        if ("true".equals(request.getParameter("rated"))) {
                    %>

                        <div class="alert alert-success mt-3 mb-0">
                            Your rating has been submitted successfully.
                        </div>

                    <%
                        }
                    %>

                    <%
                        if ("rating".equals(request.getParameter("error"))) {
                    %>

                        <div class="alert alert-danger mt-3 mb-0">
                            Unable to submit your rating.
                        </div>

                    <%
                        }
                    %>

                </div>

            </div>

        </div>

    </div>

<%
    } else {
%>

    <div class="alert alert-danger text-center">

        Movie not found.

    </div>

<%
    }
%>

</div>

<footer class="bg-dark text-white text-center py-3">

    <p class="mb-0">
        © 2026 MovieMind - Movie Recommendation System
    </p>

</footer>

</body>

</html>