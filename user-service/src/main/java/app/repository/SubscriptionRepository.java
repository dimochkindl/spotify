package app.repository;

import app.entity.Subscription;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    @Query(value = "select s from Subscription s where s.name = :name")
    Optional<Subscription> findByName(@Param("name") String name);

}
