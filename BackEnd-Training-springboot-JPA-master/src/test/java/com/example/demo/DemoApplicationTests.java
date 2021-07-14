package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
     @Autowired
     PersonRepository repository;
	@Test
	public void testCreate(){
		Person person=new Person();
		person.setDep(2);
		person.setId(4);
		person.setName("Heba");

        repository.save(person);
	}

}
