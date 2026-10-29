<%@ page import="com.moviemind.model.User" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Admin Dashboard - MovieMind</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<%
    User user = (User) session.getAttribute("user");

    if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand fw-bold" href="admin-dashboard">
            MovieMind Admin
        </a>

        <div>

            <span class="text-white me-3">
                Admin: <%= user.getName() %>
            </span>

            <a href="logout" class="btn btn-danger btn-sm">
                Logout
            </a>

        </div>

    </div>

</nav>

<div class="container py-5">

    <div class="text-center mb-5">

        <h1 class="fw-bold">
            Admin Dashboard
        </h1>

        <p class="text-muted">
            Manage MovieMind and monitor recommendation performance.
        </p>

    </div>

    <div class="row g-4">

        <div class="col-md-6 col-lg-3">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h4>
                        Movies
                    </h4>

                    <p class="text-muted">
                        Add, update and delete movies.
                    </p>

                    <a
                        href="admin-movies"
                        class="btn btn-primary">

                        Manage Movies

                    </a>

                </div>

            </div>

        </div>

        <div class="col-md-6 col-lg-3">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h4>
                        Users
                    </h4>

                    <p class="text-muted">
                        Manage registered users.
                    </p>

                    <a
                        href="admin-users"
                        class="btn btn-primary">

                        Manage Users

                    </a>

                </div>

            </div>

        </div>

        <div class="col-md-6 col-lg-3">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h4>
                        Settings
                    </h4>

                    <p class="text-muted">
                        Configure recommendation settings.
                    </p>

                    <a
                        href="admin-settings"
                        class="btn btn-primary">

                        Settings

                    </a>

                </div>

            </div>

        </div>

        <div class="col-md-6 col-lg-3">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <h4>
                        Analytics
                    </h4>

                    <p class="text-muted">
                        Analyze recommendation effectiveness.
                    </p>

                    <a
                        href="admin-analytics"
                        class="btn btn-primary">

                        View Analytics

                    </a>

                </div>

            </div>

        </div>

    </div>

</div>

<footer class="bg-dark text-white text-center py-3">

    <p class="mb-0">
        © 2026 MovieMind - Admin Panel
    </p>

</footer>

</body>

</html>