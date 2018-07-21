package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Lesson;
import com.example.simpleapp.webdev.models.Module;
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

  @PostMapping("/api/course/{cid}/module/{mid}/lesson")
  public Lesson createLesson(@RequestBody Lesson lesson) {
    lessonRepository.save(lesson);
    return lesson;
  }

  @GetMapping("/api/course/{CID}/module/{MID}/lesson")
  public List<Lesson> findAllLessonsForModule(
          @PathVariable("MID") int moduleId) {
    Optional<Module> data = moduleRepository.findById(moduleId);
    if (data.isPresent()) {
      Module module = data.get();
      return module.getLessons();
    } else {
      return null;
    }
  }


  @DeleteMapping("/api/lesson/{LID}")
  public void deleteLesson(@PathVariable("LID") int lessonsId) {
    lessonRepository.deleteById(lessonsId);
  }

  @GetMapping("/api/lesson")
  public List<Lesson> findAllLessons() {
    return (List<Lesson>) lessonRepository.findAll();
  }


    @GetMapping("/api/lesson/{LID}")
  public Lesson findLessonById(@PathVariable("LID") int lessondId) {
    Optional<Lesson> data = lessonRepository.findById(lessondId);
    if (data.isPresent()) {
      return data.get();
    } else {
      return null;
    }
  }


  @PutMapping("/api/lesson/{id}")
  public Lesson updateLesson(@PathVariable("id") int lessonId, @RequestBody Lesson newLesson) {
    Optional<Lesson> data = lessonRepository.findById(lessonId);
    if(data.isPresent()) {
      Lesson lesson = data.get();
      lesson.setTitle(newLesson.getTitle());
      lessonRepository.save(lesson);
      return lesson;
    }
    return null;
  }

}