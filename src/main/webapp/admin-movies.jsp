<%@ page import="java.util.List" %>
<%@ page import="com.moviemind.model.Movie" %>

<%
    List<Movie> movies =
            (List<Movie>) request.getAttribute("movies");
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Manage Movies - MovieMind</title>

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

    <h2 class="fw-bold mb-4">
        Manage Movies
    </h2>

    <%
        if ("true".equals(
                request.getParameter("added"))) {
    %>

        <div class="alert alert-success">
            Movie added successfully.
        </div>

    <%
        }

        if ("true".equals(
                request.getParameter("updated"))) {
    %>

        <div class="alert alert-success">
            Movie updated successfully.
        </div>

    <%
        }

        if ("true".equals(
                request.getParameter("deleted"))) {
    %>

        <div class="alert alert-success">
            Movie deleted successfully.
        </div>

    <%
        }

        if (request.getParameter("error") != null) {
    %>

        <div class="alert alert-danger">
            Unable to complete the movie operation.
            Please check the entered information.
        </div>

    <%
        }
    %>

    <!-- ADD MOVIE -->

    <div class="card shadow-sm mb-5">

        <div class="card-body">

            <h4 class="mb-4">
                Add New Movie
            </h4>

            <form action="admin-movie-add"
                  method="post">

                <div class="row g-3">

                    <div class="col-md-6">

                        <label class="form-label">
                            Movie Title
                        </label>

                        <input
                            type="text"
                            name="title"
                            class="form-control"
                            required>

                    </div>

                    <div class="col-md-6">

                        <label class="form-label">
                            Genre
                        </label>

                        <input
                            type="text"
                            name="genre"
                            class="form-control"
                            placeholder="Action"
                            required>

                    </div>

                    <div class="col-md-6">

                        <label class="form-label">
                            Language
                        </label>

                        <input
                            type="text"
                            name="language"
                            class="form-control"
                            placeholder="English"
                            required>

                    </div>

                    <div class="col-md-3">

                        <label class="form-label">
                            Release Year
                        </label>

                        <input
                            type="number"
                            name="releaseYear"
                            class="form-control"
                            min="1900"
                            max="2100"
                            required>

                    </div>

                    <div class="col-md-3">

                        <label class="form-label">
                            Rating
                        </label>

                        <input
                            type="number"
                            name="rating"
                            class="form-control"
                            min="0"
                            max="5"
                            step="0.1"
                            required>

                    </div>

                    <div class="col-12">

                        <label class="form-label">
                            Poster URL
                        </label>

                        <input
                            type="text"
                            name="posterUrl"
                            class="form-control">

                    </div>

                    <div class="col-12">

                        <label class="form-label">
                            Description
                        </label>

                        <textarea
                            name="description"
                            class="form-control"
                            rows="3"></textarea>

                    </div>

                    <div class="col-12">

                        <button
                            type="submit"
                            class="btn btn-primary">

                            Add Movie

                        </button>

                    </div>

                </div>

            </form>

        </div>

    </div>

    <!-- MOVIE LIST -->

    <div class="card shadow-sm">

        <div class="card-body">

            <h4 class="mb-4">
                Existing Movies
            </h4>

            <%
                if (movies == null || movies.isEmpty()) {
            %>

                <div class="alert alert-info">
                    No movies available.
                </div>

            <%
                } else {
            %>

                <div class="table-responsive">

                    <table class="table table-bordered
                                  table-hover align-middle">

                        <thead class="table-dark">

                            <tr>

                                <th>ID</th>
                                <th>Title</th>
                                <th>Genre</th>
                                <th>Language</th>
                                <th>Year</th>
                                <th>Rating</th>
                                <th>Actions</th>

                            </tr>

                        </thead>

                        <tbody>

                        <%
                            for (Movie movie : movies) {
                        %>

                            <tr>

                                <td>
                                    <%= movie.getMovieId() %>
                                </td>

                                <td>
                                    <%= movie.getTitle() %>
                                </td>

                                <td>
                                    <%= movie.getGenre() %>
                                </td>

                                <td>
                                    <%= movie.getLanguage() %>
                                </td>

                                <td>
                                    <%= movie.getReleaseYear() %>
                                </td>

                                <td>
                                    <%= movie.getRating() %>
                                </td>

                                <td>

                                    <button
                                        type="button"
                                        class="btn btn-warning btn-sm"
                                        data-bs-toggle="modal"
                                        data-bs-target="#editModal<%= movie.getMovieId() %>">

                                        Edit

                                    </button>

                                    <form
                                        action="admin-movie-delete"
                                        method="post"
                                        class="d-inline">

                                        <input
                                            type="hidden"
                                            name="movieId"
                                            value="<%= movie.getMovieId() %>">

                                        <button
                                            type="submit"
                                            class="btn btn-danger btn-sm"
                                            onclick="return confirm('Delete this movie?');">

                                            Delete

                                        </button>

                                    </form>

                                </td>

                            </tr>

                        <%
                            }
                        %>

                        </tbody>

                    </table>

                </div>

            <%
                }
            %>

        </div>

    </div>

</div>

<!-- EDIT MODALS -->

<%
    if (movies != null) {

        for (Movie movie : movies) {
%>

<div class="modal fade"
     id="editModal<%= movie.getMovieId() %>"
     tabindex="-1">

    <div class="modal-dialog modal-lg">

        <div class="modal-content">

            <div class="modal-header">

                <h5 class="modal-title">
                    Edit Movie
                </h5>

                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal">
                </button>

            </div>

            <form
                action="admin-movie-update"
                method="post">

                <div class="modal-body">

                    <input
                        type="hidden"
                        name="movieId"
                        value="<%= movie.getMovieId() %>">

                    <div class="row g-3">

                        <div class="col-md-6">

                            <label class="form-label">
                                Movie Title
                            </label>

                            <input
                                type="text"
                                name="title"
                                class="form-control"
                                value="<%= movie.getTitle() %>"
                                required>

                        </div>

                        <div class="col-md-6">

                            <label class="form-label">
                                Genre
                            </label>

                            <input
                                type="text"
                                name="genre"
                                class="form-control"
                                value="<%= movie.getGenre() %>"
                                required>

                        </div>

                        <div class="col-md-6">

                            <label class="form-label">
                                Language
                            </label>

                            <input
                                type="text"
                                name="language"
                                class="form-control"
                                value="<%= movie.getLanguage() %>"
                                required>

                        </div>

                        <div class="col-md-3">

                            <label class="form-label">
                                Release Year
                            </label>

                            <input
                                type="number"
                                name="releaseYear"
                                class="form-control"
                                value="<%= movie.getReleaseYear() %>"
                                required>

                        </div>

                        <div class="col-md-3">

                            <label class="form-label">
                                Rating
                            </label>

                            <input
                                type="number"
                                name="rating"
                                class="form-control"
                                min="0"
                                max="5"
                                step="0.1"
                                value="<%= movie.getRating() %>"
                                required>

                        </div>

                        <div class="col-12">

                            <label class="form-label">
                                Poster URL
                            </label>

                            <input
                                type="text"
                                name="posterUrl"
                                class="form-control"
                                value="<%= movie.getPosterUrl() %>">

                        </div>

                        <div class="col-12">

                            <label class="form-label">
                                Description
                            </label>

                            <textarea
                                name="description"
                                class="form-control"
                                rows="3"><%= movie.getDescription() %></textarea>

                        </div>

                    </div>

                </div>

                <div class="modal-footer">

                    <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal">

                        Cancel

                    </button>

                    <button
                        type="submit"
                        class="btn btn-primary">

                        Save Changes

                    </button>

                </div>

            </form>

        </div>

    </div>

</div>

<%
        }
    }
%>

<footer class="bg-dark text-white text-center py-3">

    <p class="mb-0">
        © 2026 MovieMind - Admin Movie Management
    </p>

</footer>

<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>

</html>