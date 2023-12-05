package co.com.movies.db.dto;

import io.r2dbc.spi.Parameter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Schedule")
@Data
@NoArgsConstructor
public class ScheduleDTO implements Persistable<Integer> {

    @Id
    private Integer id;
    @Column("movie_id")
    private String movieId;
    @Column("date_schedule")
    private LocalDateTime date;
    private Integer price;

    @Transient
    private boolean newObj;

    public ScheduleDTO(Integer scheduleId, String movieId, LocalDateTime date, Integer price) {
        this.id = scheduleId;
        this.movieId = movieId;
        this.date = date;
        this.price = price;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.newObj;
    }

}
