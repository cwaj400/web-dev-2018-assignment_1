package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.User;
import com.example.simpleapp.webdev.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserService {

  @Autowired
  UserRepository repository;

  @PostMapping("/register")
  public User register(@RequestBody User user) {
    return repository.save(user);
  }


  @PostMapping("/login")
  public List<User> login(@RequestBody User user) {
    return (List<User>) repository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
  }


  @DeleteMapping("/api/user-admin/{userId}")
  public void deleteUser(@PathVariable("userId") int id) {
    repository.deleteById(id);
  }

  @GetMapping("/api/user-admin")
  public List<User> findAllUsers() {
    return (List<User>) repository.findAll();
  }







  @PostMapping("/register")
  public User createUser(@RequestBody User user) {
    return repository.save(user);
  }




  @PutMapping("/api/user/{userId}")
  public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
    Optional<User> data = repository.findById(userId);
    if (data.isPresent()) {
      User user = data.get();
      user.setFirstName(newUser.getFirstName());
      repository.save(user);
      return user;
    }
    return null;
  }


  @GetMapping("/api/user/{userId}")
  public User findUserById(@PathVariable("userId") int userId) {
    Optional<User> data = repository.findById(userId);
    if (data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @GetMapping("/api/user/{userId}")
  public User findUserUsername(@PathVariable("username") String username) {
    Optional<User> data = repository.findByUsername(username);
    if (data.isPresent()) {
      return data.get();
    }
    return null;
  }
}