package com.example.demo.services;

import com.example.demo.models.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    public List<Person> getAll();
    public Person addToList(Person person);
    public String delete(Integer personId);
    public String Update(Person person);



}
