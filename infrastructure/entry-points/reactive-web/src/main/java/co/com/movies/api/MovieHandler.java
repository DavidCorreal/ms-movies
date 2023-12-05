package co.com.movies.api;

import co.com.movies.api.builder.MovieBuilder;
import co.com.movies.api.dto.request.RateDTO;
import co.com.movies.api.dto.request.ScheduleDTO;
import co.com.movies.usecase.MovieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MovieHandler {

    private static final String PATH_VARIABLE_MOVIE_ID = "movieId";
    private static final String PATH_VARIABLE_SCHEDULE_ID = "scheduleId";
    private final MovieUseCase movieUseCase;

    public Mono<ServerResponse> updateSchedule(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ScheduleDTO.class)
                .map(MovieBuilder::toSchedule)
                .flatMap(schedule ->
                        movieUseCase.updateSchedule(
                                serverRequest.pathVariable(PATH_VARIABLE_MOVIE_ID),
                                        Integer.parseInt(serverRequest.pathVariable(PATH_VARIABLE_SCHEDULE_ID)),
                                        schedule)
                                .map(MovieBuilder::toScheduleDTO)
                                .flatMap(dto -> ServerResponse.ok().bodyValue(dto)));
    }

    public Mono<ServerResponse> getMoviesWithScheduleAndRate(ServerRequest serverRequest) {
        return movieUseCase.getMoviesWithScheduleAndRate()
                .map(MovieBuilder::toDataTransferObjectSchedule)
                .collectList()
                .flatMap(dto -> ServerResponse.ok().bodyValue(dto));
    }

    public Mono<ServerResponse> getMovieDetails(ServerRequest serverRequest) {

        return movieUseCase.getMovieDetails(serverRequest.pathVariable(PATH_VARIABLE_MOVIE_ID))
                .map(MovieBuilder::toDataTransferObject)
                .flatMap(dto -> ServerResponse.ok().bodyValue(dto));
    }

    public Mono<ServerResponse> rateMovie(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(RateDTO.class)
                .map(MovieBuilder::toRateModel)
                .flatMap(rate ->
                        movieUseCase.rateMovie(
                                        serverRequest.pathVariable(PATH_VARIABLE_MOVIE_ID),
                                        rate)
                                .map(MovieBuilder::toRateDTO)
                                .flatMap(dto -> ServerResponse.ok().bodyValue(dto)));
    }

}