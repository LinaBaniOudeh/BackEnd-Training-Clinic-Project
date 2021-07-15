package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.PhoneNumber;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
		person.setName("jojo");
		PhoneNumber p1=new PhoneNumber();
		p1.setNumber("0595724009");
		p1.setType("cell");


		PhoneNumber p2=new PhoneNumber();
		p2.setNumber("02734499");
		p2.setType("home");

		person.addPhoneNumber(p1);
		person.addPhoneNumber(p2);

		repository.save(person);
	}


 @Test
 @Transactional
	public void testLoadCustomer(){
		Optional<Person> person=repository.findById(4);
		if (person.isPresent()){
	          System.out.println(person.get().getName());
			Set<PhoneNumber> numbers=person.get().getNumbers();
			numbers.forEach(number-> System.out.println(number.getNumber()));
            }
	}

	@Test
	public void testUpdateCustomer(){
		Optional<Person> person=repository.findById(12);
		if (person.isPresent()){
			Person p1= person.get();
			p1.setName("John");
			//System.out.println(person.get().getName());
			Set<PhoneNumber> numbers=p1.getNumbers();
			numbers.forEach(number-> number.setType("cell"));
			repository.save(p1);
		}
	}
	@Test
	public void testDelete(){


		repository.deleteById(12);
	}
}
