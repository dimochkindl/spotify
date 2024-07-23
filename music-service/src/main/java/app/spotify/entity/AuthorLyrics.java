package app.spotify.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "author_lyrics", schema = "spotik")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorLyrics {
    @Id
    private int id;

    @ManyToOne
    private Music music;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Album album;
}
