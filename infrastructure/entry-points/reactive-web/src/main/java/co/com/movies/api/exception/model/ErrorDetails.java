package co.com.movies.api.exception.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonSerialize(using = ErrorDetailsSerializer.class)
@AllArgsConstructor
@Getter
public enum ErrorDetails {

    API_MOVIE_NOT_FOUND(124, "movie not found", "http://www.omdbapi.com");

    private final Integer errorCode;
    private final String errorMessage;
    private final String referenceUrl;
}