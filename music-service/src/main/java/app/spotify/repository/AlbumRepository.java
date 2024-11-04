package app.spotify.repository;

import app.spotify.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "select a from Album a where a.title = :title")
    Optional<Album> findByTitle(@Param("title") String title);

    @Query(value = "select a from Album a inner join Artist ar where ar.nickname in :artistNames")
    List<Album> findAllBy(@Param("artistNames") List<String> artistNames);

    @Query(value = "select a from Album a inner join Music m where m.title = :track")
    Optional<Album> findByMusicTitle(@Param("track")String track);

    @Query("select a from Album a inner join ArtistMusic am where am.date between :start and :end ")
    List<Album> findInDate (@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
