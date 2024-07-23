package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
