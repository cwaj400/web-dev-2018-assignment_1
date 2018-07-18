package com.example.simpleapp.webdev.repositories;

import com.example.simpleapp.webdev.models.Lesson;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{

}
