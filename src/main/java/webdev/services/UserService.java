package webdev.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import webdev.models.User;

@RestController
public class UserService {


  @PostMapping("/register")
  public String register(User user) {
    return "Hello from register!";
  }


}
