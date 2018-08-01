package com.example.simpleapp.webdev.repositories;

import com.example.simpleapp.webdev.models.Widget;

import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {


}
