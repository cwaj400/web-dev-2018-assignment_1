package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Course;
import com.example.simpleapp.webdev.models.User;
import com.example.simpleapp.webdev.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService {

  @Autowired
  CourseRepository courseRepository;

  java.sql.Date date;

  @PostMapping("/api/course")
  public Course createCourse(@RequestBody Course course) {
    date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    course.setModified(date);
    course.setCreated(date);
    courseRepository.save(course);
    return course;
  }

  @DeleteMapping("/api/course/{courseId}")
  public void deleteCourse(@PathVariable(value = "courseId") int courseId) {
    courseRepository.deleteById(courseId);
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
    date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    if (data.isPresent()) {
      Course dbCourse = data.get();
      dbCourse.setModified(date);

      if (newCourse.getTitle() != null) {
        dbCourse.setTitle(newCourse.getTitle());
      }
      return courseRepository.save(dbCourse);
    }
    return null;
  }
}