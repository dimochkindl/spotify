package app.spotify.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MusicDto(
        int id,

        @NotBlank String title,

        String artist,

        String duration,

        @DefaultValue(value = "0") int numberOfPlays,

        @NotNull String genre,

        @NotNull String lyrics_ref
) {
}
