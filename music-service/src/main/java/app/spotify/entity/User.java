package app.spotify.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")
@Data
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
