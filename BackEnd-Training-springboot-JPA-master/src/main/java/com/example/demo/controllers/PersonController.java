package com.example.demo.controllers;
import java.util.List;

import com.example.demo.models.Person;
import com.example.demo.servicesImp.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PersonController {
    @Autowired
    PersonServiceImp service;

    @GetMapping("/person")
    public List<Person> getAll(){
        return service.getAll();
    }

    @PostMapping("/person")
    public String addOne(@RequestBody Person person) {

        return service.addToList(person);
    }



    @DeleteMapping(value = "/person/{Id}")
    public String deleteOne(@PathVariable Integer Id) {
        return service.delete(Id);
    }


    @PutMapping("/person")
    public String updatePerson(@RequestBody Person person) {
        return service.Update(person);

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