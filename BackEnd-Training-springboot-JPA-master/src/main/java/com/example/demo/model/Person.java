package com.example.demo.model;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
//THIS IS THE FIRST VERSION OF PERSON
@Entity
@Table(name = "person")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(nullable = false,unique = true)

    @NotEmpty(message = "must fill name field")
    @Size(min =3,max = 15,message = "name must be at least 3 character and not exceed 15")
    private  String name;
    private int dep;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private Set<PhoneNumber> numbers;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "persons_projects",joinColumns = @JoinColumn(name = "person_id",referencedColumnName = "id")
            ,inverseJoinColumns =@JoinColumn(name = "project_id",referencedColumnName = "id") )
    private Set<Project> projects;
    @OneToOne(mappedBy = "person")
    private BankAccount bankAccount;

    public Person() {

        super();
    }

    public Person(int id, String name, int dep, Set<PhoneNumber> numbers) {
    }

    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDep() {
        return dep;
    }

    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dep=" + dep +
                ", numbers=" + numbers +
                '}';
    }

    public void addPhoneNumber(PhoneNumber number){
        if(number !=null){
            if(numbers==null){
                numbers=new HashSet<>();
            }
            number.setPerson(this);
            numbers.add(number);
        }
    }

    public static class Builder {
        private int id;
        private  String name;
        private int dep;
        private Set<PhoneNumber> numbers;


        public Builder setNumbers(Set<PhoneNumber> numbers) {
            this.numbers = numbers;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDep(int dep) {
            this.dep= dep;
            return this;
        }

        public Person build(){

            return new Person(id,name,dep, numbers);
        }
    }
}