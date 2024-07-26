package app.spotify.repository;

import app.spotify.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(value = "select a from Author a where a.nickname = :name")
    Optional<Author> findByName(@Param("name")String name);

    @Query(value = "select a from Author a inner join Music m where m.title = :track")
    List<Author> findByMusic(@Param("track")String track);

    @Query(value = "select a from Author a inner join Music m where m.genre = :genre")
    List<Author> findByGenre(@Param("genre") String genre);

    @Query(value = "select a from Author a inner join Album al where al.title = :album")
    List<Author> findByAlbum(@Param("album") String album);

}
