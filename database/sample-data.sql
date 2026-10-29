USE moviemind;

INSERT IGNORE INTO users
(name, email, password, role)
VALUES
('Admin', 'admin@moviemind.com', 'admin123', 'ADMIN'),
('Demo User', 'user@moviemind.com', 'user123', 'USER');


INSERT IGNORE INTO movies
(title, description, genre, language, release_year, rating, poster_url)
VALUES
('Inception',
 'A thief who enters the dreams of others is given a chance to erase his past.',
 'Sci-Fi',
 'English',
 2010,
 4.8,
 'https://image.tmdb.org/t/p/w500/oYuLEt3zVCKq57qu2F8dT7NIa6f.jpg'),

('Interstellar',
 'A group of astronauts travels through a wormhole to find a new home for humanity.',
 'Sci-Fi',
 'English',
 2014,
 4.9,
 'https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg'),

('The Dark Knight',
 'Batman faces a dangerous criminal mastermind who creates chaos in Gotham City.',
 'Action',
 'English',
 2008,
 4.9,
 'https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg'),

('3 Idiots',
 'Three engineering students experience friendship, college life and the pressure of education.',
 'Comedy',
 'Hindi',
 2009,
 4.7,
 'https://image.tmdb.org/t/p/w500/66A9MqXOyV7f6mD6cQ8l5Jk9J7P.jpg'),

('Dangal',
 'A former wrestler trains his daughters to become successful wrestlers.',
 'Drama',
 'Hindi',
 2016,
 4.8,
 'https://image.tmdb.org/t/p/w500/p2lVQJ9J5x5H5Z5Z5Z5Z5Z5Z5Z.jpg'),

('Avengers: Endgame',
 'The Avengers attempt to undo the devastating events caused by Thanos.',
 'Action',
 'English',
 2019,
 4.7,
 'https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg'),

('Taare Zameen Par',
 'A teacher helps a young student overcome his difficulties and discover his abilities.',
 'Drama',
 'Hindi',
 2007,
 4.8,
 'https://image.tmdb.org/t/p/w500/jm7M9WfM3Z8K8V8V8V8V8V8V8V.jpg'),

('The Matrix',
 'A computer programmer discovers that reality is not what it seems.',
 'Sci-Fi',
 'English',
 1999,
 4.7,
 'https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg');