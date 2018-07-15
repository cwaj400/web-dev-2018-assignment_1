package com.example.simpleapp.webdev.repositories;

import com.example.simpleapp.webdev.models.Course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends CrudRepository<Integer, Course> {

}
