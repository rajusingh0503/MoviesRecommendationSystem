<%@ page import="com.moviemind.model.User" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Profile - MovieMind</title>

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

<%
    User user = (User) request.getAttribute("user");

    if (user != null) {
%>

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-body p-5">

                    <h2 class="text-center fw-bold mb-4">
                        My Profile
                    </h2>

                    <div class="mb-3">

                        <label class="form-label fw-bold">
                            User ID
                        </label>

                        <input
                            type="text"
                            class="form-control"
                            value="<%= user.getUserId() %>"
                            readonly>

                    </div>

                    <div class="mb-3">

                        <label class="form-label fw-bold">
                            Name
                        </label>

                        <input
                            type="text"
                            class="form-control"
                            value="<%= user.getName() %>"
                            readonly>

                    </div>

                    <div class="mb-3">

                        <label class="form-label fw-bold">
                            Email
                        </label>

                        <input
                            type="email"
                            class="form-control"
                            value="<%= user.getEmail() %>"
                            readonly>

                    </div>

                    <div class="mb-4">

                        <label class="form-label fw-bold">
                            Account Role
                        </label>

                        <input
                            type="text"
                            class="form-control"
                            value="<%= user.getRole() %>"
                            readonly>

                    </div>

                    <div class="d-grid">

                        <a
                            href="home"
                            class="btn btn-primary">

                            Back to Home

                        </a>

                    </div>

                </div>

            </div>

        </div>

    </div>

<%
    } else {
%>

    <div class="alert alert-danger text-center">
        Unable to load profile.
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