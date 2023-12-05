package co.com.movies;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Movie {

    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private List<Rating> ratings;
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String type;
    private String dvd;
    private String boxOffice;
    private String production;
    private String website;
    private String response;
    private List<Schedule> schedule;
    private List<Rate> rates;

    @Getter
    @Builder
    public static class Rating {
        private String source;
        private String value;
    }

}
