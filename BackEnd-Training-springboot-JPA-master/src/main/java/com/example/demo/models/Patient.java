package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class Patient extends Person{
    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors;


    public Patient() {
    }

    public Patient(Long id, String name, Set<PhoneNumber> numbers, BankAccount bankAccount, String address, Date dob) {
        super(id, name, numbers, bankAccount, address, dob);
    }
}