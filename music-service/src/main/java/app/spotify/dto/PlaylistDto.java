package app.spotify.dto;

import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record PlaylistDto(

        int id,

        @NotBlank @Max(30) @Min(5) String username,

        @NotBlank @Max(100) String name,

        @Max(8)
        @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss")
        String duration,

        @NotNull
        int numberOfTracks,

        @DefaultValue("0") int numberOfPlays
) {
}
