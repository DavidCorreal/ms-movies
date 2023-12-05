package co.com.movies.api.exception;

import co.com.movies.api.exception.model.ErrorResponse;
import co.com.movies.api.exception.model.MovieNotFoundException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {

    public GlobalExceptionHandler(DefaultErrorAttributes errorAttributes, ApplicationContext applicationContext,
                                  ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, new WebProperties.Resources(), applicationContext);
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        super.setMessageReaders(serverCodecConfigurer.getReaders());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(final ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse(final ServerRequest request) {
        return Mono.just(request)
                .map(this::getError)
                .flatMap(Mono::error)
                .onErrorResume(MovieNotFoundException.class, this::buildErrorResponse)
                .onErrorResume(this::buildErrorResponse)
                .cast(ErrorResponse.class)
                .flatMap(this::buildResponse);
    }

    private Mono<ErrorResponse> buildErrorResponse(MovieNotFoundException notFoundException) {
        var errorResponse = buildErrorResponse(HttpStatus.NOT_FOUND,
                notFoundException.getMessage()
        );
        return Mono.just(errorResponse);
    }

    private Mono<ErrorResponse> buildErrorResponse(Throwable throwable) {
        var errorResponse = buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "Unexpected Error"
        );
        return Mono.just(errorResponse);
    }

    private static ErrorResponse buildErrorResponse(HttpStatus status, String message) {
        return ErrorResponse.builder()
                .traceId(RandomStringUtils.randomAlphanumeric(10))
                .message(message)
                .timestamp(OffsetDateTime.now())
                .status(status)
                .build();
    }

    private Mono<ServerResponse> buildResponse(ErrorResponse errorResponse) {

        return ServerResponse.status(errorResponse.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(errorResponse);
    }
}