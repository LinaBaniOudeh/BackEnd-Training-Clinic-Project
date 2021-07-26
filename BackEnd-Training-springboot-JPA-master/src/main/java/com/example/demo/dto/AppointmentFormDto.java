package com.example.demo.dto;

import com.example.demo.models.BankAccount;
import com.example.demo.models.PhoneNumber;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

public class AppointmentFormDto {


    @NotEmpty(message = "must fill name field")
    @Size(min =3,max = 15,message = "name must be at least 3 character and not exceed 15")
    private  String name;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private Set<PhoneNumber> numbers;
    private String address;
    @Temporal(TemporalType.DATE)
    private Date dob;


    @OneToOne(mappedBy = "person")
    private BankAccount bankAccount;
}
