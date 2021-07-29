package com.example.demo.servicesImp;
//import java.sql.Date;
import java.util.List;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAll() {

        return (List<Person>) personRepository.findAll();
    }

    public String addToList(Person person) {
        personRepository.save(person);
        return "Added Successfully";
    }

    public ResponseEntity<Object> delete(Integer personId) {
        Person existingUser = this.personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + personId));
        this.personRepository.delete(existingUser);
        return ResponseEntity.ok().build();

    }

    public String Update(Person person) {
        personRepository.save(person);
        return "success";
    }


}