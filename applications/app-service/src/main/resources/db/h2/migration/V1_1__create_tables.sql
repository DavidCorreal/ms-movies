CREATE TABLE Movies (
    imdbID VARCHAR(50) PRIMARY KEY,
    title VARCHAR(256),
    description VARCHAR(256)
);

CREATE TABLE Schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    movie_id VARCHAR(50),
    date_schedule TIMESTAMP,
    price INTEGER,
    FOREIGN KEY (movie_id) REFERENCES Movies(imdbID)
);

CREATE TABLE Rate (
    id INT PRIMARY KEY AUTO_INCREMENT,
    movie_id VARCHAR(50),
    rating INT,
    comment VARCHAR(100),
    date_rate TIMESTAMP,
    FOREIGN KEY (movie_id) REFERENCES Movies(imdbID)
);