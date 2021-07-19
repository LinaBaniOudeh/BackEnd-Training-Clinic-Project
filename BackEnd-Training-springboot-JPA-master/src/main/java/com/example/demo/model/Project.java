package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;
 @Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "projects")
    private Set<Person> persons;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

     @Override
     public String toString() {
         return "Project{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 '}';
     }
 }
