package com.example.simpleapp.webdev.repositories;

import com.example.simpleapp.webdev.models.Module;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Integer> {
}
