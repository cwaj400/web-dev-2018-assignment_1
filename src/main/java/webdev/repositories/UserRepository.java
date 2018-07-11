package webdev.repositories;


import webdev.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findUserByName(String username);
  List<User> findUserByCredentials(String username, String password);

}
