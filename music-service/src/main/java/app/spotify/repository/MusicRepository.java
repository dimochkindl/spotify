package app.spotify.repository;

import app.spotify.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {
    @Query(value = "select m from Music m where m.title = :title")
    List<Music> findAllByTitle(@Param("title")String title);

    @Query(value = "select m from Music m inner join Author a where a.nickname = :artist ")
    List<Music> findAllByArtist(@Param("artist")String artist);

    @Query(value = "select m from Music m inner join Album a where a.title = :album and m.title = :title")
    Optional<Music> findByAlbumAndTitle(@Param("album") String album,@Param("title") String title);

    @Query(value = "select m from Music m inner join Author au inner join Album al where au.nickname = :artist and al.title = :album")
    List<Music> findByArtistAndAlbum(@Param("artist")String artist, @Param("album") String album);

    @Query(value = "select m from Music m inner join Album a where a.title = :album")
    List<Music> findAllByAlbum(@Param("album")String album);
}
