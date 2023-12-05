package co.com.movies.db;

import co.com.movies.Movie;
import co.com.movies.Rate;
import co.com.movies.Schedule;
import co.com.movies.api.exception.model.MovieNotFoundException;
import co.com.movies.db.builder.MovieBuilder;
import co.com.movies.db.dto.MovieDTO;
import co.com.movies.db.repository.MoviesRepository;
import co.com.movies.db.repository.RateRepository;
import co.com.movies.db.repository.ScheduleRepository;
import co.com.movies.usecase.gateway.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.function.TupleUtils;

@Service
@RequiredArgsConstructor
public class MovieRepositoryAdapter implements MovieRepository {

    private final MoviesRepository moviesRepository;
    private final ScheduleRepository scheduleRepository;
    private final RateRepository rateRepository;

    @Override
    public Flux<Movie> getMoviesWithScheduleAndRate() {
        return moviesRepository.getMoviesAndSchedule()
                .switchIfEmpty(Mono.error(() -> new MovieNotFoundException("")))
                .flatMap(movieDTO ->
                                Mono.zip(scheduleRepository.findByMovieId(movieDTO.getIdx())
                                                .collectList(),
                                        rateRepository.findByMovieId(movieDTO.getIdx())
                                                .collectList())
                                        .map(TupleUtils.function((schedules, rates) -> new MovieDTO(movieDTO, schedules, rates)))
                        )
                .map(MovieBuilder::toMovieModel);
    }

    @Override
    public Mono<Schedule> updateSchedule(String movieId, Integer scheduleId, Schedule schedule) {
        return scheduleRepository.save(MovieBuilder.toScheduleDTO(schedule, scheduleId, movieId))
                .map(MovieBuilder::toScheduleModel);
    }

    @Override
    public Mono<Rate> rateMovie(String movieId, Rate rate) {
        return rateRepository.save(MovieBuilder.toRateDTO(rate, movieId))
                .map(MovieBuilder::toRateModel);
    }

}