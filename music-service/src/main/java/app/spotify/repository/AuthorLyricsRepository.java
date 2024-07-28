package app.spotify.repository;

import app.spotify.entity.AuthorLyrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorLyricsRepository extends CrudRepository<AuthorLyrics, Long> {

}
