package com.example.demo.models;
import lombok.*;
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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
public  class Person {
    //private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(nullable = false, unique = true)

    @NotEmpty(message = "must fill name field")
    @Size(min = 3, max = 15, message = "name must be at least 3 character and not exceed 15")
    private String name;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PhoneNumber> numbers;

    private String address;
    @Temporal(TemporalType.DATE)
    private Date dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private BankAccount bankAccount;



}