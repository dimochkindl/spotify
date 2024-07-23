package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "artist_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistUser extends User{
    private String info;

    private String genre;
}