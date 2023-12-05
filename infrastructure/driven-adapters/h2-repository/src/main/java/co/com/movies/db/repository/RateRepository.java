package co.com.movies.db.repository;

import co.com.movies.db.dto.RateDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface RateRepository extends ReactiveCrudRepository<RateDTO, Integer> {

    Flux<RateDTO> findByMovieId(String movieId);

}