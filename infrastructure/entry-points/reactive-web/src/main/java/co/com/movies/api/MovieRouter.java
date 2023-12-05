package co.com.movies.api;

import co.com.movies.api.openapi.OpenAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;

@Configuration
@RequiredArgsConstructor
public class MovieRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(MovieHandler movieHandler) {
        return route()
                .PATCH("/movies/{movieId}/schedule/{scheduleId}", movieHandler::updateSchedule, OpenAPI::updateSchedule)
                .GET("/movies", movieHandler::getMoviesWithScheduleAndRate, OpenAPI::getMoviesWithScheduleAndRate)
                .GET("/movies/{movieId}", movieHandler::getMovieDetails, OpenAPI::getMovieDetails)
                .POST("/movies/{movieId}/rate", movieHandler::rateMovie, OpenAPI::rateMovie)
                .build();
    }

}