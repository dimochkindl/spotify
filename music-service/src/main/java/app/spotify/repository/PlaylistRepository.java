package app.spotify.repository;

import app.spotify.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    @Query(value = "select p from Playlist p where p.name = :title")
    Optional<Playlist> findByTitle(@Param("title") String title);

    @Query(value = "select p from Playlist p inner join UserPlaylist up where up.user.username = :username")
    List<Playlist> findAllByUser(@Param("artistNames") String username);

    @Query(value = "select p from Playlist p inner join Music m where m.title = :track")
    List<Playlist> findByMusicTitle(@Param("track") String track);

    @Query(value = "select p from Playlist p where p.id = 1")
    Optional<Playlist> findLiked();
}
