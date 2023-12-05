package co.com.movies;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Schedule {

    private LocalDateTime date;
    private Integer price;

}