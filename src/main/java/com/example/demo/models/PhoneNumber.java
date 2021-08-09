package com.example.demo.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity

public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;
    private String number;
    private String type;



//    @ManyToOne
//    @JoinColumn(name="phone_id", nullable=false)

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "person_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)

//    @ManyToOne
//    @JoinColumn(name="person_id", nullable=false)
//    private Person person;

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

