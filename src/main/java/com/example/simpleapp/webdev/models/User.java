package com.example.simpleapp.webdev.models;


import javax.persistence.*;


@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String role;
  private String dob;

  public User() {
    //Empty
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(String username, String password, String firstName, String lastName,
              String email, String phone, String role, String dob) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.role = role;
    this.dob = dob;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getUsername() {

    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getRole() {
    return role;
  }

  public String getDob() {
    return dob;
  }
}
