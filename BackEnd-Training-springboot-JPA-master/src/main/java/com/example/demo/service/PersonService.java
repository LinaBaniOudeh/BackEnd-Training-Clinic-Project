package com.example.demo.service;
import java.util.Collections;
//import java.sql.Date;
import java.util.List;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAll() {

        return  personRepository.findAll();
    }

    public Person addToList(Person person) {
        personRepository.save(person);
        return personRepository.save(person);
    }

    public String delete(Integer personId) {
        try {
            personRepository.deleteById(personId);

        } catch (Exception e) {

            return "This  Id " + "{" + personId + "}" + " Not Exist !!";
        }
        return "success";

    }

    public String UpdatePersonList(Person person) {
        personRepository.save(person);
        return "success";
    }



}