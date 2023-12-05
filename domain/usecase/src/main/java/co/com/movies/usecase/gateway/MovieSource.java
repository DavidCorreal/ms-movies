package co.com.movies.usecase.gateway;

import co.com.movies.Movie;
import reactor.core.publisher.Mono;

public interface MovieSource {

    Mono<Movie> getMovieDetails(String movieId);

}