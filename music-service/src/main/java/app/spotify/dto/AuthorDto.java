package app.spotify.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record AuthorDto(
        int id,

        @NotBlank @Size(min = 5, max = 30) String nick,

        @DefaultValue("0") String numberOfListeners,

        String genre
) {
}
