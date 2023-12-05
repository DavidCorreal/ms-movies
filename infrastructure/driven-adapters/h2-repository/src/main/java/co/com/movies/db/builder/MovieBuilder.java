package co.com.movies.db.builder;

import co.com.movies.Movie;
import co.com.movies.Rate;
import co.com.movies.Schedule;
import co.com.movies.db.dto.MovieDTO;
import co.com.movies.db.dto.RateDTO;
import co.com.movies.db.dto.ScheduleDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MovieBuilder {

    public static Movie toMovieModel(MovieDTO movieDTO) {
        return Movie.builder()
                .title(movieDTO.getTitle())
                .plot(movieDTO.getDescription())
                .imdbID(movieDTO.getIdx())
                .schedule(toScheduleModel(movieDTO.getSchedule()))
                .rates(toRateModel(movieDTO.getRates()))
                .build();
    }

    private static List<Schedule> toScheduleModel(List<ScheduleDTO> scheduleDTOS) {

        return scheduleDTOS.stream()
                .map(scheduleDTO -> Schedule.builder()
                        .price(scheduleDTO.getPrice())
                        .date(scheduleDTO.getDate())
                        .build())
                .collect(Collectors.toList());
    }

    public static ScheduleDTO toScheduleDTO(Schedule schedule, Integer scheduleId, String movieId) {

        return new ScheduleDTO(scheduleId, movieId, schedule.getDate(), schedule.getPrice());
    }

    public static Schedule toScheduleModel(ScheduleDTO scheduleDTO) {

        return Schedule.builder()
                .price(scheduleDTO.getPrice())
                .date(scheduleDTO.getDate())
                .build();
    }

    private static List<Rate> toRateModel(List<RateDTO> rateDTOS) {

        return rateDTOS.stream()
                .map(rateDTO -> Rate.builder()
                        .rating(rateDTO.getRating())
                        .comment(rateDTO.getComment())
                        .build())
                .collect(Collectors.toList());
    }

    public static Rate toRateModel(RateDTO rateDTO) {
        return Rate.builder()
                .rating(rateDTO.getRating())
                .comment(rateDTO.getComment())
                .build();
    }

    public static RateDTO toRateDTO(Rate rate, String movieId) {
        return new RateDTO(null, movieId, rate.getRating(), rate.getComment(), LocalDateTime.now());
    }

}