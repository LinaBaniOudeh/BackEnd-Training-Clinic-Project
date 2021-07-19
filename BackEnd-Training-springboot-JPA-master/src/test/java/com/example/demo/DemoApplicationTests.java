package com.example.demo;

import com.example.demo.model.BankAccount;
import com.example.demo.model.Person;
import com.example.demo.model.PhoneNumber;
import com.example.demo.model.Project;
import com.example.demo.repository.BankAccountRepository;
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

	@Autowired
	BankAccountRepository Accountrepository;

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
	public void testLoadPerson(){
		Optional<Person> person=repository.findById(4);
		if (person.isPresent()){
	          System.out.println(person.get().getName());
			Set<PhoneNumber> numbers=person.get().getNumbers();
			numbers.forEach(number-> System.out.println(number.getNumber()));
            }
	}

	@Test
	public void testUpdatePerson(){
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

	@Test
	public void testMtoMCreatePerson(){

		Person person=new Person();
		person.setName("Ali");
		person.setDep(1);
		HashSet<Project> projects=new HashSet<Project>();
		Project project=new Project();

		project.setName("Spring boot jpa");
		projects.add(project);
		person.setProjects(projects);
		repository.save(person);


	}

	@Test
	@Transactional
	public void testMtoMFindPerson(){
		Optional<Person> person=repository.findById(1);
		if (person.isPresent()){
			Person p1= person.get();

			System.out.println(p1);
			System.out.println(p1.getProjects());

		}

	}

	@Test
	public void testOneTonOneCreateBankAccount(){

		BankAccount bankAccount=new BankAccount();
		bankAccount.setType("Student Account");
		bankAccount.setBalance(8679.99);
		Person person=new Person();
		person.setName("stephan");
		person.setDep(1);
		PhoneNumber p1=new PhoneNumber();
		p1.setNumber("0595024009");
		p1.setType("cell");
		PhoneNumber p2=new PhoneNumber();
		p2.setNumber("02739879");
		p2.setType("home");
		HashSet<Project> projects=new HashSet<Project>();
		Project project=new Project();

		project.setName("Spring boot jpa");
		projects.add(project);
		person.setProjects(projects);
		person.addPhoneNumber(p1);
		person.addPhoneNumber(p2);
		bankAccount.setPerson(person);

		Accountrepository.save(bankAccount);



	}
}
