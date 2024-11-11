package app.spotify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "music")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 8, nullable = false)
    @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss")
    private String duration;

    @Column
    private int numberOfPlays;

    @Column(length = 100)
    private String genre;

    @Column
    @Pattern(regexp = "^/music/[^/]+$", message = "Lyrics URL must be in the format /music/(file)")
    private String lyricsUrl;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn
    private Playlist playlist;

    @ManyToOne
    @JoinColumn
    private ArtistMusic artistMusic;
}
