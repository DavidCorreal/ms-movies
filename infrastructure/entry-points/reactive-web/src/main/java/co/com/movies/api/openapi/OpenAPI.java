package co.com.movies.api.openapi;

import co.com.movies.api.dto.request.RateDTO;
import co.com.movies.api.dto.request.ScheduleDTO;
import co.com.movies.api.dto.response.MovieDTO;
import co.com.movies.api.dto.response.MovieWithScheduleDTO;
import co.com.movies.api.exception.model.ErrorResponse;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.experimental.UtilityClass;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.content.Builder.contentBuilder;
import static org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder;
import static org.springdoc.core.fn.builders.requestbody.Builder.requestBodyBuilder;
import static org.springdoc.core.fn.builders.schema.Builder.schemaBuilder;

@UtilityClass
public class OpenAPI {

    public void updateSchedule(Builder builder) {
        builder.operationId("Update Schedule")
                .description("Update show schedule and prices")
                .parameter(
                        parameterBuilder()
                                .in(ParameterIn.PATH)
                                .name("movieId")
                                .description("Id of the movie to modify")
                                .required(true))
                .parameter(
                        parameterBuilder()
                                .in(ParameterIn.PATH)
                                .name("scheduleId")
                                .description("Id of the schedule to modify")
                                .required(true))
                .requestBody(requestBodyBuilder()
                        .description("Request body to update the schedule and price of a function")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(ScheduleDTO.class))))
                .response(responseBuilder()
                        .description("Successful")
                        .responseCode(HttpStatus.OK.value()+"")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(MovieWithScheduleDTO.class))))
                .response(responseBuilder()
                        .description("Unexpected Error")
                        .responseCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation((ErrorResponse.class)))));
    }

    public void getMoviesWithScheduleAndRate(Builder builder) {
        builder.operationId("Get Movies With Schedule And Rate")
                .description("Get movie schedules and ratings")
                .response(responseBuilder()
                        .description("Successful")
                        .responseCode(HttpStatus.OK.value() + "")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(MovieWithScheduleDTO.class))))
                .response(responseBuilder()
                        .description("Unexpected Error")
                        .responseCode(HttpStatus.INTERNAL_SERVER_ERROR.value() + "")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation((ErrorResponse.class)))));
    }

    public void getMovieDetails(Builder builder) {
        builder.operationId("Get detail movie")
                .description("Get the details of the movie from the IMDB repository")
                .parameter(
                        parameterBuilder()
                                .in(ParameterIn.PATH)
                                .name("movieId")
                                .description("Id of the movie to modify")
                                .required(true))
                .response(responseBuilder()
                        .description("Successful")
                        .responseCode(HttpStatus.OK.value()+"")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(MovieDTO.class))))
                .response(responseBuilder()
                        .description("Unexpected Error")
                        .responseCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation((ErrorResponse.class)))));
    }

    public void rateMovie(Builder builder) {
        builder.operationId("Rate movie")
                .description("Rate 1-5 stars about a particular movie")
                .parameter(
                        parameterBuilder()
                                .in(ParameterIn.PATH)
                                .name("movieId")
                                .description("Id of the movie to modify")
                                .required(true))
                .requestBody(requestBodyBuilder()
                        .description("Body request to rate a movie")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(RateDTO.class))))
                .response(responseBuilder()
                        .description("Successful")
                        .responseCode(HttpStatus.OK.value()+"")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation(MovieDTO.class))))
                .response(responseBuilder()
                        .description("Unexpected Error")
                        .responseCode(HttpStatus.INTERNAL_SERVER_ERROR.value()+"")
                        .content(contentBuilder()
                                .mediaType(MediaType.APPLICATION_JSON_VALUE)
                                .schema(schemaBuilder().implementation((ErrorResponse.class)))));
    }

}