/**
  * Repository for User entities
**/

package com.DexAPI.Repository;
import com.DexAPI.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query(value = "SELECT * FROM users WHERE `username` LIKE :username", nativeQuery = true)
    User findByUsername(String username);
}