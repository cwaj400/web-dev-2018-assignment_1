package com.example.simpleapp.webdev.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;


  @OneToMany(mappedBy = "course")
  private List<Module> modules;

  private String professor;
  //@Temporal(TemporalType.DATE)
  private Date created;

  //@Temporal(TemporalType.DATE)
  private Date modified;

  public Course(String title, String professor, Date created, Date modified) {
    this.title = title;
    this.professor = professor;
    this.created = created;
    this.modified = modified;
  }


  public List<Module> getModules() {
    return modules;
  }

  public void setModules(List<Module> modules) {
    this.modules = modules;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }

  public String getProfessor() {
    return this.professor;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }
}