package app.repository;

import app.entity.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    @Query(value = "delete from User u where u.id = :id")
    void deleteUser(@Param("id") int userId);

}
