package com.example.demo.servicesImp;
//import java.sql.Date;
import java.util.List;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService {
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