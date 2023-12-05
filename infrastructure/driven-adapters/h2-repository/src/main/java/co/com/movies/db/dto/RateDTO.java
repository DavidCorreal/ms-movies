package co.com.movies.db.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Rate")
@Data
@NoArgsConstructor
public class RateDTO implements Persistable<String> {

    @Id
    private String id;
    @Column("movie_id")
    private String movieId;
    private Integer rating;
    private String comment;
    @Column("date_rate")
    private LocalDateTime date;

    @Transient
    private boolean newObj;

    @Override
    @Transient
    public boolean isNew() {
        return this.newObj || id == null;
    }

    public RateDTO(String id, String movieId, Integer rating, String comment, LocalDateTime date) {
        this.id = id;
        this.movieId = movieId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

}