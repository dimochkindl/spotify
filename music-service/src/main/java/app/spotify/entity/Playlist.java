package app.spotify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
@Data
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 8)
    @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Duration must be in the format mm:ss")
    private String duration;

    @Column(name = "number_of_tracks")
    private int numberOfTracks;

    @Column(name = "number_of_plays")
    private int numberOfPlays;

    @OneToMany(mappedBy = "playlist")
    private List<Music> songs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "playlist")
    private List<UserPlaylist> userPlaylist;
}
