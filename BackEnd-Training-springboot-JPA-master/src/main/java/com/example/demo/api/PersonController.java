package com.example.demo.api;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonService service;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getAllUsers(){
        return service.getAll();
    }

    @PostMapping("/persons")
    public Person addOne(@RequestBody Person person) {
        return service.addToList(person);
    }

//    @GetMapping("/persons")
//    public List<Person> getAllUsers(){
//        return service.getAll();
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/persons/{Id}")
    public String deleteOne(@PathVariable Integer Id) {
        return service.delete(Id);
    }


    @PutMapping("/persons")
    public String updatePerson(@RequestBody Person person) {
        return service.UpdatePersonList(person);

    }

//    @GetMapping("/persons/search")
//    public List<Person> FindByid(@RequestParam("id")  int id)
//    {
//        return personRepository.findById(id);
//    }
//    @GetMapping("/persons/search")
//    public List<Person> FindByname(@RequestParam("name")  String name)
//    {
//        return personRepository.findByName(name);
//    }



}