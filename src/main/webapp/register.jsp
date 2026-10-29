<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Register - MovieMind</title>

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
                    Create Account
                </h2>

                <% if ("failed".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">
                        Registration failed. Please try again.
                    </div>
                <% } %>

                <form action="register" method="post">

                    <div class="mb-3">

                        <label class="form-label">
                            Full Name
                        </label>

                        <input
                            type="text"
                            name="name"
                            class="form-control"
                            placeholder="Enter your name"
                            required>

                    </div>

                    <div class="mb-3">

                        <label class="form-label">
                            Email
                        </label>

                        <input
                            type="email"
                            name="email"
                            class="form-control"
                            placeholder="Enter your email"
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
                            placeholder="Create a password"
                            required>

                    </div>

                    <button
                        type="submit"
                        class="btn btn-primary w-100">
                        Register
                    </button>

                </form>

                <p class="text-center mt-3 mb-0">

                    Already have an account?

                    <a href="login.jsp">
                        Login
                    </a>

                </p>

            </div>

        </div>

    </div>

</div>

</body>
</html>