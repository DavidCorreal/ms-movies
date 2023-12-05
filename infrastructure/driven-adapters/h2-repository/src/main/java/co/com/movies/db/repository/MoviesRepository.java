package co.com.movies.db.repository;

import co.com.movies.db.dto.MovieDTO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MoviesRepository extends ReactiveCrudRepository<MovieDTO, String> {

    @Query(value = """
            SELECT
                Movies.imdbID as idx,
                Movies.title as title,
                Movies.description as description
            FROM
                Movies""")
    Flux<MovieDTO> getMoviesAndSchedule();
}