package app.repository;

import app.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    @Query(value = "select p from Playlist p where p.creatorUsername = :name")
    List<PlaylistRepository> findByCreator(@Param("name") String name);
}
