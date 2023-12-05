package co.com.movies.api.dto.response;

import co.com.movies.api.dto.request.RateDTO;
import co.com.movies.api.dto.request.ScheduleDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MovieWithScheduleDTO {

    private String imdbID;
    private String title;
    private String description;
    private List<ScheduleDTO> schedule;
    private List<RateDTO> rates;

}
