package app.spotify.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MusicDto
(
        int id,

        @NotBlank(message = "The title of the song can not be null") String title,

        @NotBlank(message = "Artist can not be null")List<String> artists,

        @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss")
        String duration,

        @DefaultValue(value = "0") int numberOfPlays,

        @NotBlank(message = "The genre can not be null") String genre

) implements SimpleDto {
}
