package co.com.movies.db.repository;

import co.com.movies.db.dto.ScheduleDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ScheduleRepository extends ReactiveCrudRepository<ScheduleDTO, Integer> {

    Flux<ScheduleDTO> findByMovieId(String movieId);

}