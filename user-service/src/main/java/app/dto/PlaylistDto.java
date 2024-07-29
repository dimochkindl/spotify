package app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record PlaylistDto(
        int id,

        @NotBlank String title,

        String creator,

        @Positive String duration,

        @FutureOrPresent @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Minsk")
        String creationDate,

        @DefaultValue("0") int numberOfPlays,

        @DefaultValue("0") int numberOfTracks
) {
}
