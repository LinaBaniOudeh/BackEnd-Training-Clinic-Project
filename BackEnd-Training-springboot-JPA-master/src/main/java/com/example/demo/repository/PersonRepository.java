package com.example.demo.repository;

import com.example.demo.model.Person;
import com.example.demo.model.PersonPKId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, PersonPKId> {
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
        List<Person> findByDep(int dep);
        List<Person> findByNameAndDep(String name,int id);
        Person save(Person o);


        void deleteById(Integer personId);
}
