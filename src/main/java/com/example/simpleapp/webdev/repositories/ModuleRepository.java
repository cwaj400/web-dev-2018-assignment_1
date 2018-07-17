package com.example.simpleapp.webdev.repositories;

import com.example.simpleapp.webdev.models.Module;

import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
}
