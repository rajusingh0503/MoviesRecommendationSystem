<%@ page import="java.util.Map" %>

<%
    Map<String, Double> weights =
            (Map<String, Double>) request.getAttribute("weights");

    double genreWeight =
            weights != null
            ? weights.getOrDefault("genre_weight", 0.40)
            : 0.40;

    double ratingWeight =
            weights != null
            ? weights.getOrDefault("rating_weight", 0.25)
            : 0.25;

    double behaviorWeight =
            weights != null
            ? weights.getOrDefault("behavior_weight", 0.20)
            : 0.20;

    double popularityWeight =
            weights != null
            ? weights.getOrDefault("popularity_weight", 0.15)
            : 0.15;
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Recommendation Settings - MovieMind</title>

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

    <div class="row justify-content-center">

        <div class="col-lg-8">

            <div class="card shadow-sm">

                <div class="card-body p-4">

                    <h2 class="mb-2">
                        Recommendation Settings
                    </h2>

                    <p class="text-muted">
                        Configure the weights used by the
                        MovieMind recommendation engine.
                    </p>

                    <%
                        if ("true".equals(
                                request.getParameter("saved"))) {
                    %>

                        <div class="alert alert-success">
                            Recommendation settings updated successfully.
                        </div>

                    <%
                        }

                        if ("weights".equals(
                                request.getParameter("error"))) {
                    %>

                        <div class="alert alert-danger">
                            The total of all weights must be exactly 1.00
                            and no weight can be negative.
                        </div>

                    <%
                        }

                        if ("invalid".equals(
                                request.getParameter("error"))) {
                    %>

                        <div class="alert alert-danger">
                            Please enter valid numeric values.
                        </div>

                    <%
                        }

                        if ("save".equals(
                                request.getParameter("error"))) {
                    %>

                        <div class="alert alert-danger">
                            Unable to save all recommendation settings.
                        </div>

                    <%
                        }
                    %>

                    <form action="admin-settings"
                          method="post">

                        <div class="mb-3">

                            <label class="form-label">
                                Genre Weight
                            </label>

                            <input
                                type="number"
                                name="genreWeight"
                                class="form-control"
                                step="0.01"
                                min="0"
                                max="1"
                                value="<%= genreWeight %>"
                                required>

                            <small class="text-muted">
                                Current value:
                                <%= genreWeight %>
                            </small>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Rating Weight
                            </label>

                            <input
                                type="number"
                                name="ratingWeight"
                                class="form-control"
                                step="0.01"
                                min="0"
                                max="1"
                                value="<%= ratingWeight %>"
                                required>

                            <small class="text-muted">
                                Current value:
                                <%= ratingWeight %>
                            </small>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Behavior Weight
                            </label>

                            <input
                                type="number"
                                name="behaviorWeight"
                                class="form-control"
                                step="0.01"
                                min="0"
                                max="1"
                                value="<%= behaviorWeight %>"
                                required>

                            <small class="text-muted">
                                Current value:
                                <%= behaviorWeight %>
                            </small>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">
                                Popularity Weight
                            </label>

                            <input
                                type="number"
                                name="popularityWeight"
                                class="form-control"
                                step="0.01"
                                min="0"
                                max="1"
                                value="<%= popularityWeight %>"
                                required>

                            <small class="text-muted">
                                Current value:
                                <%= popularityWeight %>
                            </small>

                        </div>

                        <div class="alert alert-info">

                            <strong>Important:</strong>

                            The four weights must add up to
                            <strong>1.00</strong>.

                            <br>

                            Example:

                            <strong>
                                0.40 + 0.25 + 0.20 + 0.15 = 1.00
                            </strong>

                        </div>

                        <button
                            type="submit"
                            class="btn btn-primary w-100">

                            Save Recommendation Settings

                        </button>

                    </form>

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