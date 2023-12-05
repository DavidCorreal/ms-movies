package co.com.movies.usecase.gateway;

import co.com.movies.Movie;
import co.com.movies.Rate;
import co.com.movies.Schedule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieRepository {

    Flux<Movie> getMoviesWithScheduleAndRate();

    Mono<Schedule> updateSchedule(String movieId, Integer scheduleId, Schedule schedule);

    Mono<Rate> rateMovie(String movieId, Rate rate);

}