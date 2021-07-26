package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@IdClass(DoctorPKId.class)
public class Doctor extends Person {
   // @Id
    private int dep;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "doctors_patients",joinColumns = @JoinColumn(name = "doctor_id",referencedColumnName = "id")
            ,inverseJoinColumns =@JoinColumn(name = "patient_id",referencedColumnName = "id") )
    private Set<Patient> patients;

    public Doctor() {
    }

    public void setDep(int dep) {
        this.dep = dep;
    }
    public int getDep() {
        return dep;
    }

}
