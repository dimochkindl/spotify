package app.spotify.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "artist_music")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creation_date")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "artist_music")
    private List<Artist> artists;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "artist_music")
    private List<Music> music;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "artist_music")
    private List<Album> albums;
}
