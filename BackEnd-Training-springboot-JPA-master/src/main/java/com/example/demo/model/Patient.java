package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Patient extends Person{
    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors;

    public Patient() {
    }
}
