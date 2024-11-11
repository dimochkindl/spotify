package app.spotify.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MusicDto implements SimpleDto {

    private int id;

    @NotBlank(message = "The title of the song can not be null")
    private String title;

    @NotBlank(message = "Artist can not be null")
    private List<String> artists;

    @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss")
    private String duration;

    private int numberOfPlays;

    @NotBlank(message = "The genre can not be null")
    private String genre;

    public MusicDto(String title, List<String> artists, String duration, String genre) {
        this.title = title;
        this.artists = artists;
        this.duration = duration;
        numberOfPlays = 0;
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(@NotBlank(message = "The title of the song can not be null") String title) {
        this.title = title;
    }

    public void setArtists(@NotBlank(message = "Artist can not be null") List<String> artists) {
        this.artists = artists;
    }

    public void setDuration(@Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss") String duration) {
        this.duration = duration;
    }

    public void setNumberOfPlays(int numberOfPlays) {
        this.numberOfPlays = numberOfPlays;
    }

    public void setGenre(@NotBlank(message = "The genre can not be null") String genre) {
        this.genre = genre;
    }
}

