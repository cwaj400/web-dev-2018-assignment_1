package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Course;
import com.example.simpleapp.webdev.models.User;
import com.example.simpleapp.webdev.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class CourseService {

  @Autowired
  CourseRepository courseRepository;

  @PostMapping("/api/course")
  public Course createCourse(@RequestBody Course course) {
    courseRepository.save(course);
    return course;
  }

  @DeleteMapping("/api/course/{id}")
  public void deleteCourse(@PathVariable(value = "id") int id) {
    courseRepository.deleteById(id);
  }

  @GetMapping("/api/course")
  public List<Course> findAllCourses() {
    return (List<Course>) courseRepository.findAll();
  }


  @GetMapping("/api/course/{id}")
  public Course findCourseByID(@PathVariable("id") int courseID) {
    if (courseRepository.findById(courseID).isPresent()) {
      return courseRepository.findById(courseID).get();
    }
    return null;
  }


  @PutMapping("/api/course/{id}")
  public Course updateCourse(@PathVariable("id") int id, @RequestBody Course newCourse) {
    Optional<Course> data = courseRepository.findById(id);
    if (data.isPresent()) {
      Course dbCourse = data.get();
      if (newCourse.getCreated() != null) {
        dbCourse.setCreated(newCourse.getCreated());
      }
      if (newCourse.getModified() != null) {
        dbCourse.setModified(newCourse.getModified());
      }
      if (newCourse.getProfessor() != null) {
        dbCourse.setProfessor(newCourse.getProfessor());
      }
      if (newCourse.getTitle() != null) {
        dbCourse.setTitle(newCourse.getTitle());
      }
      return courseRepository.save(dbCourse);
    }
    return null;
  }
}