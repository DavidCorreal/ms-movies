package co.com.movies.api.exception.model;

import lombok.Getter;


public class MovieNotFoundException extends RuntimeException {
    @Getter
    private final String movieId;
    private static final String MESSAGE = "movies not found";

    public MovieNotFoundException(String id) {
        super(MESSAGE);
        this.movieId = id;
    }
}