package app.spotify.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record AlbumDto(

        @NotNull int id,

        @NotBlank(message = "title must be not blank") @Size(max = 50) String title,

        String artist,

        @DefaultValue("0") int numberOfPlays,

        @DefaultValue("0") int numberOfTracks,

        @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss")
        String duration,

        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Minsk") String date,

        @NotBlank @Max(50) String type
) {
}
