package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Course;
import com.example.simpleapp.webdev.models.Lesson;
import com.example.simpleapp.webdev.models.User;
import com.example.simpleapp.webdev.repositories.CourseRepository;
import com.example.simpleapp.webdev.repositories.LessonRepository;
import com.example.simpleapp.webdev.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {

  @Autowired
  CourseRepository courseRepository;

  @Autowired
  ModuleRepository moduleRepository;

  @Autowired
  LessonRepository lessonRepository;

  @PostMapping("/api/lesson")
  public Lesson createLesson(@RequestBody Lesson lesson) {
    lessonRepository.save(lesson);
    return lesson;
  }
}