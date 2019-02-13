/**
 * 
 */
package it.nmadlk.repository;

import org.springframework.data.repository.CrudRepository;

import it.nmadlk.models.User;

import java.util.Optional;

/**
 * @author Navo
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * If the username does not exist we mark the return type as optional. It is easier to handle null cases here
     * @param username
     * @return
     */
    Optional<User> findByEmail(String username);
}
