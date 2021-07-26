package com.example.demo.repositories;

import com.example.demo.models.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
        @Query("from Person")
        List<Person> findAll();
        Person findById(int id);
        @Query("from Person")
        List<Person> findAllPersons(Pageable pageable);
        @Query(value = "select * from person",nativeQuery = true)
        List<Person> findAllPersonsNQ();

        @Query(value = "select * from person where name=:name",nativeQuery = true)
        List<Person> findByNameNQ(@Param("name")String name);

        List<Person> findByName(String name,Pageable pageble);
       // List<Person> findById(int id);
        Person save(Person o);


        void deleteById(Integer personId);
}
