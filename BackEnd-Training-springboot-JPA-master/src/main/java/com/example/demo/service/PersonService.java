package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAll();
    public Person addToList(Person person);
    public String delete(Integer personId);
    public String UpdatePersonList(Person person);



}
