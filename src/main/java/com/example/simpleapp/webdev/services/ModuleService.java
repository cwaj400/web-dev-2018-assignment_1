package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Course;
import com.example.simpleapp.webdev.models.Module;
import com.example.simpleapp.webdev.repositories.CourseRepository;
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
public class ModuleService {

  @Autowired
  CourseRepository courseRepository;

  @Autowired
  ModuleRepository moduleRepository;

  @PostMapping("/api/course/{courseId}/module")
  public Module createModule(@PathVariable("courseId") int courseId,
                             @RequestBody Module newModule) {
    Optional<Course> data = courseRepository.findById(courseId);
    if (data.isPresent()) {
      Course course = data.get();
      newModule.setCourse(course);
      return moduleRepository.save(newModule);
    } else {
      return null;
    }
  }

  @GetMapping("/api/course/{courseId}/module")
  public List<Module> findAllModulesForCourse(@PathVariable("courseId") int courseId) {
    Optional<Course> data =
            courseRepository.findById(courseId);
    if (data.isPresent()) {
      Course course = data.get();
      return course.getModules();
    } else {
      return null;
    }
  }

  @GetMapping("/api/module/{moduleId}")
  public Module findModuleById(@PathVariable("moduleId") int moduleId) {
    Optional<Module> data = moduleRepository.findById(moduleId);
    if (data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @DeleteMapping("/api/module/{mId}")
  public void deleteModule(@PathVariable("mId") int moduleId) {
    moduleRepository.deleteById(moduleId);
  }

  @PutMapping("/api/module/{moduleId}")
  public Module updateModule(@PathVariable("moduleId") int moduleId, @RequestBody Module newModule) {
    Optional<Module> data = moduleRepository.findById(moduleId);
    if (data.isPresent()) {
      Module module = data.get();
      module.setTitle(newModule.getTitle());
      moduleRepository.save(module);
      return module;
    }
    return null;
  }


}
