package com.example.demo.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

   // @NotEmpty(message = "must fill name field")
   @Column(name="name")

    private  String name;
    @Column(name="dep")

    private int dep;

    public Person(int id, String name, int dep) {
        this.id = id;
        this.name = name;
        this.dep = dep;
    }

    public Person() {
       super();
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dep=" + dep +
                '}';
    }

    public static class Builder {
        private int id;
        private  String name;
        private int dep;

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

            return new Person(id,name,dep);
        }

    }
}




