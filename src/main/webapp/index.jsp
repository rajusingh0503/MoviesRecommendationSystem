<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>MovieMind - Movie Recommendation System</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?v=2">Z
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">

        <a class="navbar-brand fw-bold" href="index.jsp">
            MovieMind
        </a>

        <div>
            <a href="login.jsp" class="btn btn-outline-light me-2">
                Login
            </a>

            <a href="register.jsp" class="btn btn-primary">
                Register
            </a>
        </div>

    </div>
</nav>

<section class="py-5 bg-light">
    <div class="container text-center py-5">

        <h1 class="display-4 fw-bold">
            Discover Movies You'll Love
        </h1>

        <p class="lead mt-3">
            MovieMind recommends movies based on your
            favorite genres and languages.
        </p>

        <div class="mt-4">

            <a href="register.jsp" class="btn btn-primary btn-lg me-2">
                Get Started
            </a>

            <a href="login.jsp" class="btn btn-outline-dark btn-lg">
                Login
            </a>

        </div>

    </div>
</section>

<section class="py-5">
    <div class="container">

        <h2 class="text-center mb-5">
            Why MovieMind?
        </h2>

        <div class="row g-4">

            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">

                        <h4>Personalized Recommendations</h4>

                        <p class="text-muted">
                            Get movie recommendations based on
                            your preferences.
                        </p>

                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">

                        <h4>Rate Movies</h4>

                        <p class="text-muted">
                            Rate movies and help improve your
                            recommendation experience.
                        </p>

                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">

                        <h4>Build Your Watchlist</h4>

                        <p class="text-muted">
                            Save movies that you want to watch later.
                        </p>

                    </div>
                </div>
            </div>

        </div>

    </div>
</section>

<footer class="bg-dark text-white text-center py-3">
    <p class="mb-0">
        © 2026 MovieMind - Movie Recommendation System
    </p>
</footer>

</body>
</html>