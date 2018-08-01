package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Lesson;
import com.example.simpleapp.webdev.models.Widget;
import com.example.simpleapp.webdev.repositories.LessonRepository;
import com.example.simpleapp.webdev.repositories.WidgetRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class WidgetService {


  @Autowired
  WidgetRepository widgetRepository;


  @Autowired
  LessonRepository lessonRepository;



  @PostMapping("/api/widget")
  public List<Widget> saveWidgets(@RequestBody List<Widget> widgets) {
    return widgets;
  }


    @GetMapping("/api/lesson/{lessonId}/widget")
    public List<Widget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
      Optional<Lesson> data = lessonRepository.findById(lessonId);
      if(data.isPresent()) {
        Lesson lesson = data.get();
        return lesson.getWidgets();
      }
      return null;
    }


    @GetMapping("/api/widget")
    public List<Widget> findAllWidgets() {
      return (List<Widget>) widgetRepository.findAll();
    }



    @PostMapping("/api/lesson/{lessonId}/widget")
    public Widget createWidget(
            @PathVariable("lessonId") int lessonId,
            @RequestBody Widget newWidget) {
      Optional<Lesson> data = lessonRepository.findById(lessonId);
      if(data.isPresent()) {
        Lesson lesson = data.get();
        newWidget.setLesson(lesson);
        return widgetRepository.save(newWidget);
      }
      return null;
    }

    @DeleteMapping("/api/widget/{widgetId}")
    public void deleteWidget(@PathVariable("widgetId") int id) {
      widgetRepository.deleteById(id);
    }

    @GetMapping("/api/widget/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
      Optional<Widget> data = widgetRepository.findById(widgetId);
      if(data.isPresent()) {
        return data.get();
      }
      return null;
    }

}