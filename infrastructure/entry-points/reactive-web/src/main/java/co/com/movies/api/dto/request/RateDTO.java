package co.com.movies.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateDTO {

    @NotNull
    @Max(value = 5, message = "The max value is 5 to rating")
    @Min(value = 1, message = "The min value is 1 to rating")
    private Integer rating;

    @NotNull
    @Size(max = 100, message = "The property 'name' must be less than or equal to 100 characters.")
    private String comment;

}