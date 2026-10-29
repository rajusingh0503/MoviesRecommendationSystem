<%@ page import="com.moviemind.model.User" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Manage Users - MovieMind</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand fw-bold" href="admin-dashboard">
            MovieMind Admin
        </a>

        <div>

            <a href="admin-dashboard"
               class="btn btn-outline-light btn-sm me-2">
                Dashboard
            </a>

            <a href="logout"
               class="btn btn-danger btn-sm">
                Logout
            </a>

        </div>

    </div>

</nav>

<div class="container py-5">

    <div class="text-center mb-5">

        <h1 class="fw-bold">
            Manage Users
        </h1>

        <p class="text-muted">
            View registered MovieMind users.
        </p>

    </div>

    <%
        List<User> users =
                (List<User>) request.getAttribute("users");
    %>

    <div class="card shadow-sm">

        <div class="card-body">

            <div class="table-responsive">

                <table class="table table-bordered table-hover align-middle">

                    <thead class="table-dark">

                        <tr>

                            <th>
                                User ID
                            </th>

                            <th>
                                Name
                            </th>

                            <th>
                                Email
                            </th>

                            <th>
                                Role
                            </th>

                        </tr>

                    </thead>

                    <tbody>

                    <%
                        if (users != null && !users.isEmpty()) {

                            for (User registeredUser : users) {
                    %>

                        <tr>

                            <td>
                                <%= registeredUser.getUserId() %>
                            </td>

                            <td>
                                <%= registeredUser.getName() %>
                            </td>

                            <td>
                                <%= registeredUser.getEmail() %>
                            </td>

                            <td>

                                <%
                                    if ("ADMIN".equalsIgnoreCase(
                                            registeredUser.getRole())) {
                                %>

                                    <span class="badge bg-danger">
                                        ADMIN
                                    </span>

                                <%
                                    } else {
                                %>

                                    <span class="badge bg-primary">
                                        USER
                                    </span>

                                <%
                                    }
                                %>

                            </td>

                        </tr>

                    <%
                            }

                        } else {
                    %>

                        <tr>

                            <td
                                colspan="4"
                                class="text-center text-muted">

                                No users found.

                            </td>

                        </tr>

                    <%
                        }
                    %>

                    </tbody>

                </table>

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