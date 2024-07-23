package app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "music", schema = "spotik")
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

    private String duration;

    @Column(name = "number_of_plays")
    private int numberOfPlays;

    @Column(length = 100)
    private String genre;

    @Column(name = "lyrics_url")
    private String lyricsUrl;

    @OneToMany()
    private List<AuthorLyrics> authorLyricsList;

    @ManyToMany()
    private List<Playlist> playlistList;
}
