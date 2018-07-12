package com.example.simpleapp.webdev.repositories;


import com.example.simpleapp.webdev.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedStoredProcedureQueries;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findByUsername(String username);

  @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
  User findUserByUsernameAndPassword(@Param("username") String username,
                                     @Param("password") String password);

}
