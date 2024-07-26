package app.spotify.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false, length = 10)
    private String password;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    private List<Playlist> playlists;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
}
