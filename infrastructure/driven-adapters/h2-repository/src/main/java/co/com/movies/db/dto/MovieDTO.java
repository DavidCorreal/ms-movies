package co.com.movies.db.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("Movies")
@Data
@NoArgsConstructor
public class MovieDTO implements Persistable<String> {

    @Id
    private String imdbID;
    private String idx;
    private String title;
    private String description;
    private List<ScheduleDTO> schedule;
    private List<RateDTO> rates;

    @Override
    public String getId() {
        return imdbID;
    }

    @Transient
    private boolean newObj;

    @Override
    @Transient
    public boolean isNew() {
        return this.newObj || imdbID == null;
    }

    public MovieDTO(MovieDTO movieDTO, List<ScheduleDTO> schedule, List<RateDTO> rate) {
        this.imdbID = movieDTO.getImdbID();
        this.idx = movieDTO.getIdx();
        this.title = movieDTO.getTitle();
        this.description = movieDTO.getDescription();
        this.schedule = schedule;
        this.rates = rate;
        this.newObj = movieDTO.isNewObj();
    }

}