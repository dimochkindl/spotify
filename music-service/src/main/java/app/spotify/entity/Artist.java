package app.spotify.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "author", schema = "spotik")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(name = "listeners")
    private int numberOfListeners;

    @OneToMany
    private List<AuthorLyrics> lyricsList;

    @ManyToMany
    private List<Playlist> playlists;
}
