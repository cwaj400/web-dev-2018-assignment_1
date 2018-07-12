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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class UserService {

  @Autowired
  UserRepository repository;

  @PostMapping("/api/user")
  public User register(@RequestBody User user, HttpSession session) {
    User cu = repository.save(user);
    session.setAttribute("currentUser", cu);


    return cu;
  }

  @GetMapping("/checkLogin")
  public User checkLogin(HttpSession session) {
    return (User) session.getAttribute("currentUser");
  }


  @PostMapping("/api/login")
  public User login(@RequestBody User user, HttpSession session) {
    session.setAttribute("currentUser",
            repository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword()));
    System.out.println(session.getAttribute("currentUser"));
    System.out.println(repository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword()));
    return (User) session.getAttribute("currentUser");
  }


  @DeleteMapping("/api/user/{userId}")
  public void deleteUser(@PathVariable(value = "userId") int id) {
    repository.deleteById(id);
  }

  @GetMapping("/api/user")
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
      user.setDob(newUser.getDob());
      user.setFirstName(newUser.getFirstName());
      user.setLastName(newUser.getLastName());
      user.setRole(newUser.getRole());
      user.setUsername(newUser.getUsername());
      user.setPhone(newUser.getPhone());
      return repository.save(user);
    }
    return null;
  }

  @GetMapping("/profile")
  public Optional<User> profile(HttpSession session) {
    User currentUser = (User) session.getAttribute("currentUser");
    return repository.findById(currentUser.getId());
  }


  @GetMapping("/api/user/{userId}")
  public User findUserById(@PathVariable("userId") int userId) {
    Optional<User> data = repository.findById(userId);
    if (data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @PostMapping("/api/logout")
  public User logout(HttpSession session) {
    session.invalidate();
    return null;
  }


//  @GetMapping(value = "/api/user/", params = "username")
//  public User findUserUsername(@RequestParam("username") String username) {
//    Optional<User> data = repository.findByUsername(username);
//    if (data.isPresent()) {
//      return data.get();
//    }
//    return null;
//  }


  @RequestMapping(value = "/users/find", method = RequestMethod.GET)
  @ResponseBody
  public Optional<User> findByUsername(@RequestParam("username") String username) {
    return repository.findByUsername(username);
  }
}
