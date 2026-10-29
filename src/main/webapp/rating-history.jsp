<%@ page import="com.moviemind.model.Rating" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Rating History - MovieMind</title>

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

            <a href="profile" class="btn btn-outline-light btn-sm me-2">
                Profile
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
            Rating History
        </h1>

        <p class="text-muted">
            Movies you have rated on MovieMind.
        </p>

    </div>

    <%
        List<Rating> ratings =
                (List<Rating>) request.getAttribute("ratings");
    %>

    <div class="card shadow-sm">

        <div class="card-body">

            <%
                if (ratings != null && !ratings.isEmpty()) {
            %>

            <div class="table-responsive">

                <table class="table table-hover align-middle">

                    <thead class="table-dark">

                        <tr>

                            <th>
                                Rating ID
                            </th>

                            <th>
                                Movie ID
                            </th>

                            <th>
                                Rating
                            </th>

                        </tr>

                    </thead>

                    <tbody>

                    <%
                        for (Rating rating : ratings) {
                    %>

                        <tr>

                            <td>
                                <%= rating.getRatingId() %>
                            </td>

                            <td>
                                <%= rating.getMovieId() %>
                            </td>

                            <td>
                                ⭐ <%= rating.getRating() %>/5
                            </td>

                        </tr>

                    <%
                        }
                    %>

                    </tbody>

                </table>

            </div>

            <%
                } else {
            %>

                <div class="alert alert-info text-center mb-0">

                    You have not rated any movies yet.

                </div>

            <%
                }
            %>

        </div>

    </div>

</div>

<footer class="bg-dark text-white text-center py-3">

    <p class="mb-0">
        © 2026 MovieMind - Movie Recommendation System
    </p>

</footer>

</body>

</html>