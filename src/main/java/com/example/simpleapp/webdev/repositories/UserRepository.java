package com.example.simpleapp.webdev.repositories;


import com.example.simpleapp.webdev.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findByUsername(String username);
  List<User> findUserByUsernameAndPassword(String username, String password);

}
