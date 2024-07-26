package app.repository;

import app.entity.ArtistUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistUserRepository extends JpaRepository<ArtistUser, Integer> {
}
