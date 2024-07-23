package app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "album", schema = "spotik")
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

    private String duration;

    @Column(name = "creation_date")
    private LocalDateTime date;

    private String type;

    @OneToMany()
    private List<AuthorLyrics> authorLyricsList;

}
