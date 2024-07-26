package app.repository;

import app.entity.Subscription;
import app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u where u.username= :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query(value = "select u from User u inner join Subscription s where s.id = :id")
    List<User> findUsersInSubscription(@Param("id") int subscriptionId);
}
