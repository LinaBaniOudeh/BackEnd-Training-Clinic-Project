package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {
        @Query("from Person")
        List<Person> findAll();

        @Query("from Person")
        List<Person> findAllPersons(Pageable pageable);

    List<Person> findByName(String name,Pageable pageble);
       // List<Person> findById(int id);
        List<Person> findByDep(int dep);
        List<Person> findByNameAndDep(String name,int id);
        Person save(Person o);
}
