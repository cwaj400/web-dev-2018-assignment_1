package com.example.simpleapp.webdev.services;

import com.example.simpleapp.webdev.models.Widget;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
  @PostMapping("/api/widget")
  public List<Widget> saveWidgets(@RequestBody List<Widget> widgets) {
    return widgets;
  }

}