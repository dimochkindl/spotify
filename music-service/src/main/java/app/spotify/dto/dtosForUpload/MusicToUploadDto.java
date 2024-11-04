package app.spotify.dto.dtosForUpload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record MusicToUploadDto(
        @NotBlank(message = "The title of the song can not be null") @Max(50) String title,

        @NotBlank(message = "Artist can not be null") List<String> artists,

        @NotBlank(message = "The genre can not be null") @Max(100) String genre
) {
}
