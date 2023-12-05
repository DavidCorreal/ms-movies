package co.com.movies.source.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {

    @JsonProperty(value = "Title")
    private String title;
    @JsonProperty(value = "Year")
    private String year;
    @JsonProperty(value = "Rated")
    private String rated;
    @JsonProperty(value = "Released")
    private String released;
    @JsonProperty(value = "Runtime")
    private String runtime;
    @JsonProperty(value = "Genre")
    private String genre;
    @JsonProperty(value = "Director")
    private String director;
    @JsonProperty(value = "Writer")
    private String writer;
    @JsonProperty(value = "Actors")
    private String actors;
    @JsonProperty(value = "Plot")
    private String plot;
    @JsonProperty(value = "Language")
    private String language;
    @JsonProperty(value = "Country")
    private String country;
    @JsonProperty(value = "Awards")
    private String awards;
    @JsonProperty(value = "Poster")
    private String poster;
    @JsonProperty(value = "Ratings")
    private List<Rating> ratings;
    @JsonProperty(value = "Metascore")
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    @JsonProperty(value = " Type")
    private String type;
    @JsonProperty(value = "DVD")
    private String dvd;
    @JsonProperty(value = "BoxOffice")
    private String boxOffice;
    @JsonProperty(value = "Production")
    private String production;
    @JsonProperty(value = "Website")
    private String website;
    @JsonProperty(value = "Response")
    private String response;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Rating {
        @JsonProperty(value = "Source")
        private String source;
        @JsonProperty(value = "Value")
        private String value;

    }

}