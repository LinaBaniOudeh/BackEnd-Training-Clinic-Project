package com.example.demo.services;

import com.example.demo.models.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    public List<Person> getAll();
    public String addToList(Person person);
    public ResponseEntity<Object> delete(Integer personId);
    public String Update(Person person);



}
