package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {
List<Person> findByName(String name);
List<Person> findById(int id);

List<Person> findAll();

}
