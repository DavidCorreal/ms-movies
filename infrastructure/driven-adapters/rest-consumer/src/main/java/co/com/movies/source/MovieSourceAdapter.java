package co.com.movies.source;

import co.com.movies.Movie;
import co.com.movies.source.builder.MovieBuilder;
import co.com.movies.source.dto.MovieDTO;
import co.com.movies.usecase.gateway.MovieSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieSourceAdapter implements MovieSource {

    private final WebClient webClient;

    private static final String APIKEY = "apikey";
    private static final String ID = "i";
    private static final String API_KEY_CODE = "c06cd8ba";
    private static final String API_BASE_URL = "http://www.omdbapi.com";

    public MovieSourceAdapter() {
        this.webClient = WebClient.create(API_BASE_URL);
    }

    @Override
    public Mono<Movie> getMovieDetails(String movieId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam(APIKEY, API_KEY_CODE)
                        .queryParam(ID, movieId)
                        .build())
                .retrieve()
                .bodyToMono(MovieDTO.class)
                .map(MovieBuilder::toMovieModel);
    }

}