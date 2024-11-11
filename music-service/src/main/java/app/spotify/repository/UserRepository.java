package app.spotify.repository;

import app.spotify.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    @Query(value = "select u from AppUser u inner join Playlist p where p.name=:title")
    Optional<AppUser> findByPLaylistTitle(String title);
}
