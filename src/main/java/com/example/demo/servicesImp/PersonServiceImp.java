package com.example.demo.servicesImp;
//import java.sql.Date;
import java.util.List;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.BankAccount;
import com.example.demo.models.Person;
import com.example.demo.repositories.BankAccountRepository;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.repositories.PhoneNumberRepository;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    public List<Person> getAll() {

        return (List<Person>) personRepository.findAll();
    }

    public Person addToList(Person person) {

//        if (person.getNumbers() != null) {
//            phoneNumberRepository.saveAll(person.getNumbers());
//        }
        if (person.getNumbers() != null && person.getNumbers().size() > 0) {
            phoneNumberRepository.saveAll(person.getNumbers());
        }
        return personRepository.save(person);
    }

    public String delete(Integer personId) {
        try {
            personRepository.deleteById(personId);

        } catch (Exception e) {

            return "This Id " + "{" + personId + "}" + " Not Exist !!";
        }
        return "success";

    }
    public String Update(Person person) {
        personRepository.save(person);
        return "success";
    }


}