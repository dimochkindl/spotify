package app.spotify.dto.dtosForUpload;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

public record AlbumToUploadDto(
        @NotBlank(message = "title must be not blank") @Size(max = 250) String title,

        @NotBlank(message = "Artist can not be null") List<String> artists,

        @DefaultValue("0") int numberOfTracks,

        @NotBlank(message = "The genre can not be null") String genre,

        @NotBlank(message = "You must provide the type(album/ep..)") String type
) {
}
