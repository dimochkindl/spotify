package app.spotify.repository;

import app.spotify.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    @Query(value = "select a from Artist a where a.nickname = :name")
    Optional<Artist> findByName(@Param("name")String name);

    @Query(value = "select a from Artist a inner join Music m where m.title = :track")
    List<Artist> findByMusic(@Param("track")String track);

    @Query(value = "select a from Artist a inner join Music m where m.genre = :genre")
    List<Artist> findByGenre(@Param("genre") String genre);

    @Query(value = "select a from Artist a inner join Album al where al.title = :album")
    List<Artist> findByAlbum(@Param("album") String album);

}
