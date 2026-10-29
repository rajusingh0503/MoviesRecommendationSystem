<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Login - MovieMind</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand fw-bold" href="index.jsp">
            MovieMind
        </a>
    </div>
</nav>

<div class="container">

    <div class="row justify-content-center mt-5">

        <div class="col-md-5">

            <div class="card shadow p-4">

                <h2 class="text-center mb-4">
                    Login
                </h2>

                <% if ("invalid".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">
                        Invalid email or password.
                    </div>
                <% } %>

                <% if ("true".equals(request.getParameter("registered"))) { %>
                    <div class="alert alert-success">
                        Registration successful. Please login.
                    </div>
                <% } %>

                <% if ("true".equals(request.getParameter("logout"))) { %>
                    <div class="alert alert-success">
                        You have been logged out successfully.
                    </div>
                <% } %>

                <form action="login" method="post">

                    <div class="mb-3">
                        <label class="form-label">
                            Email
                        </label>

                        <input
                            type="email"
                            name="email"
                            class="form-control"
                            required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">
                            Password
                        </label>

                        <input
                            type="password"
                            name="password"
                            class="form-control"
                            required>
                    </div>

                    <button
                        type="submit"
                        class="btn btn-primary w-100">
                        Login
                    </button>

                </form>

                <p class="text-center mt-3 mb-0">
                    Don't have an account?
                    <a href="register.jsp">
                        Register
                    </a>
                </p>

            </div>

        </div>

    </div>

</div>

</body>
</html>