package co.com.movies;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Rate {

    private Integer rating;
    private String comment;

}