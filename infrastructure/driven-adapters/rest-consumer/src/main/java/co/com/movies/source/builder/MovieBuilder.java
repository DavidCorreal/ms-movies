package co.com.movies.source.builder;

import co.com.movies.Movie;
import co.com.movies.source.dto.MovieDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MovieBuilder {

    public static Movie toMovieModel(MovieDTO movieDTO) {

        return Movie.builder()
                .dvd(movieDTO.getDvd())
                .genre(movieDTO.getGenre())
                .actors(movieDTO.getActors())
                .awards(movieDTO.getAwards())
                .boxOffice(movieDTO.getBoxOffice())
                .country(movieDTO.getCountry())
                .director(movieDTO.getDirector())
                .plot(movieDTO.getPlot())
                .imdbID(movieDTO.getImdbID())
                .imdbRating(movieDTO.getImdbRating())
                .rated(movieDTO.getRated())
                .imdbVotes(movieDTO.getImdbVotes())
                .language(movieDTO.getLanguage())
                .metascore(movieDTO.getMetascore())
                .poster(movieDTO.getPoster())
                .title(movieDTO.getTitle())
                .production(movieDTO.getProduction())
                .ratings(toRatingModel(movieDTO.getRatings()))
                .released(movieDTO.getReleased())
                .year(movieDTO.getYear())
                .response(movieDTO.getResponse())
                .runtime(movieDTO.getRuntime())
                .type(movieDTO.getType())
                .website(movieDTO.getWebsite())
                .writer(movieDTO.getWriter())
                .build();
    }

    private static List<Movie.Rating> toRatingModel(List<MovieDTO.Rating> ratingDTO) {
        return ratingDTO.stream().map(rating -> Movie.Rating.builder()
                .source(rating.getSource())
                .value(rating.getValue())
                .build())
                .collect(Collectors.toList());
    }

}
