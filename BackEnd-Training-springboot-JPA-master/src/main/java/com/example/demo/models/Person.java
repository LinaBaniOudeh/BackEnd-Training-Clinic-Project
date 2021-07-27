package com.example.demo.models;
import net.sf.ehcache.config.PersistenceConfiguration;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//THIS IS THE FIRST VERSION OF PERSON
@Entity
@Table(name = "person")
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
public  class Person   {
    //private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    //@Column(nullable = false,unique = true)

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

    public Person() {

        super();
    }

    public Person(Long id, String name, Set<PhoneNumber> numbers, BankAccount bankAccount, String address,Date dob) {
    }

    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numbers=" + numbers +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", bankAccount=" + bankAccount +
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

//    public static class Builder {
//        private long id;
//        private  String name;
//        private Set<PhoneNumber> numbers;
//        private BankAccount bankAccount;
//        private String address;
//        @Temporal(TemporalType.DATE)
//        private Date dob;
//
//        public Builder setNumbers(Set<PhoneNumber> numbers) {
//            this.numbers = numbers;
//            return this;
//        }
//
//        public Builder setId(int id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder setBankAccount(BankAccount bankAccount) {
//            this.bankAccount = bankAccount;
//            return this;
//        }
//
//        public Builder setAddress(String address) {
//            this.address = address;
//            return this;
//        }
//
//        public Builder setDob(Date dob) {
//            this.dob = dob;
//            return this;
//        }
//
//
//
//        public Person build(){
//
//            return new Person(id,name, numbers,bankAccount, address,dob);
//        }
//    }
}