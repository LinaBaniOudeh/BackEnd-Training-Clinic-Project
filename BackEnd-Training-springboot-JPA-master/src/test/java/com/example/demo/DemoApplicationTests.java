package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.PhoneNumber;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.PersonRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Set;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }


}
