package app.spotify.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record AlbumDto(
        int id,

        @NotBlank(message = "title must be not blank") @Size(max = 50) String title,

        String author,

        @DefaultValue("0") int numberOfPlays,

        @DefaultValue("0") int numberOfTracks,

        String duration,

        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Minsk") String date,

        String type
) {
}
