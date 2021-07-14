package com.example.demo.api;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonService service;

    @GetMapping("/persons")
    public List<Person> getAllUsers(){
        return service.getAll();
    }

    @PostMapping("/persons")
    public Person addOne(@RequestBody Person person) {
        return service.addToList(person);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/persons/{Id}")
    public String deleteOne(@PathVariable Integer Id) {
        return service.delete(Id);
    }


    @PutMapping("/persons")
    public String updatePerson(@RequestBody Person person) {
        return service.UpdatePersonList(person);

    }




}