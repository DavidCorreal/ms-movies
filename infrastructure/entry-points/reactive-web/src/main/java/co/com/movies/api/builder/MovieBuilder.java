package co.com.movies.api.builder;

import co.com.movies.Movie;
import co.com.movies.Rate;
import co.com.movies.Schedule;
import co.com.movies.api.dto.response.MovieDTO;
import co.com.movies.api.dto.response.MovieWithScheduleDTO;
import co.com.movies.api.dto.request.RateDTO;
import co.com.movies.api.dto.request.ScheduleDTO;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MovieBuilder {

    public static MovieDTO toDataTransferObject(Movie movie) {
        return MovieDTO.builder()
                .dvd(movie.getDvd())
                .genre(movie.getGenre())
                .actors(movie.getActors())
                .awards(movie.getAwards())
                .boxOffice(movie.getBoxOffice())
                .country(movie.getCountry())
                .director(movie.getDirector())
                .plot(movie.getPlot())
                .imdbID(movie.getImdbID())
                .imdbRating(movie.getImdbRating())
                .rated(movie.getRated())
                .imdbVotes(movie.getImdbVotes())
                .language(movie.getLanguage())
                .metascore(movie.getMetascore())
                .poster(movie.getPoster())
                .title(movie.getTitle())
                .production(movie.getProduction())
                .ratings(movie.getRatings())
                .released(movie.getReleased())
                .year(movie.getYear())
                .response(movie.getResponse())
                .runtime(movie.getRuntime())
                .type(movie.getType())
                .website(movie.getWebsite())
                .writer(movie.getWriter())
                .build();
    }

    public static MovieWithScheduleDTO toDataTransferObjectSchedule(Movie movie) {
        return MovieWithScheduleDTO.builder()
                .schedule(toScheduleDTO(movie.getSchedule()))
                .rates(toRateDTO(movie.getRates()))
                .description(movie.getPlot())
                .imdbID(movie.getImdbID())
                .title(movie.getTitle())
                .build();
    }

    private static List<ScheduleDTO> toScheduleDTO(List<Schedule> schedules) {

        return schedules.stream()
                .map(schedule -> new ScheduleDTO(schedule.getDate(), schedule.getPrice()))
                .collect(Collectors.toList());
    }

    public static Schedule toSchedule(ScheduleDTO scheduleDTO) {

        return Schedule.builder()
                .date(scheduleDTO.getDate())
                .price(scheduleDTO.getPrice())
                .build();
    }

    public static ScheduleDTO toScheduleDTO(Schedule schedule) {

        return new ScheduleDTO(schedule.getDate(), schedule.getPrice());
    }

    private static List<RateDTO> toRateDTO(List<Rate> rates) {

        return rates.stream()
                .map(rate -> new RateDTO(rate.getRating(), rate.getComment()))
                .collect(Collectors.toList());
    }

    public static Rate toRateModel(RateDTO rateDTO) {

        return Rate.builder()
                .rating(rateDTO.getRating())
                .comment(rateDTO.getComment())
                .build();
    }

    public static RateDTO toRateDTO(Rate rate) {

        return new RateDTO(rate.getRating(), rate.getComment());
    }
}