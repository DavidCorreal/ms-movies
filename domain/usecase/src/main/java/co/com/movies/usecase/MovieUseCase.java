package co.com.movies.usecase;

import co.com.movies.Movie;
import co.com.movies.Rate;
import co.com.movies.Schedule;
import co.com.movies.usecase.gateway.MovieRepository;
import co.com.movies.usecase.gateway.MovieSource;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RequiredArgsConstructor
public class MovieUseCase {

    private final MovieSource movieSource;
    private final MovieRepository movieRepository;

    public Mono<Movie> getMovieDetails(String movieId) {

        return movieSource.getMovieDetails(movieId);
    }

    public Flux<Movie> getMoviesWithScheduleAndRate() {

        return movieRepository.getMoviesWithScheduleAndRate();
    }

    public Mono<Schedule> updateSchedule(String movieId, Integer scheduleId, Schedule schedule) {

        return movieRepository.updateSchedule(movieId, scheduleId, schedule);
    }

    public Mono<Rate> rateMovie(String movieId, Rate rate) {

        return movieRepository.rateMovie(movieId, rate);
    }
}