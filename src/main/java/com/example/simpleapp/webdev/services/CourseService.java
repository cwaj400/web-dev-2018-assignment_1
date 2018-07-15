package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Course;
import com.example.simpleapp.webdev.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseService {

  @Autowired
  CourseRepository courseRepository;

  @PutMapping("create_course")
  public Course createCourse(@RequestBody Course course) {
    courseRepository.save(course);
    return course;
  }
}
