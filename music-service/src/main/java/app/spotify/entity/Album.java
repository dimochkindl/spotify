package app.spotify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "album")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 250, nullable = false)
    private String title;

    @Column(name = "number_of_tracks")
    private int numberOfTracks;

    @Column(name = "number_of_plays")
    private int numberOfPlays;

    @Column(length = 100)
    private String genre;

    @Column(length = 8)
    @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss")
    private String duration;

    @Column(length = 30)
    @NotBlank
    private String type;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private ArtistMusic artistMusic;

}
