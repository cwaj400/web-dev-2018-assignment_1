package webdev.repositories;

import webdev.models.User;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findById(int userId);

  List<User> findUserByCredentials(String username, String password);

  List<User> findAll();

  User save(User user);

  void deleteById(int id);
}
