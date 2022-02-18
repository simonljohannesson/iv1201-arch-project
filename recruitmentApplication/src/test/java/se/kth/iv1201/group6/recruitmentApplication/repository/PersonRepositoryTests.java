package se.kth.iv1201.group6.recruitmentApplication.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import se.kth.iv1201.group6.recruitmentApplication.model.Person;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersonRepositoryTests {
    
    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    public PersonRepository repository;

    @Test
    public void testExample() throws Exception {
        Person newPerson = new Person();
        newPerson.setEmail("example@email.com");
        newPerson.setUsername("coolguy");
        newPerson.setName("Göran");
        newPerson.setLast_name("Persson");
        newPerson.setPassword("123456");
        newPerson.setPnr("199901015555");
        newPerson.setRole_id((long)2);
        this.entityManager.persist(newPerson);
        Person person = this.repository.findByUsername("coolguy");
        assertEquals("coolguy", person.getUsername());
        assertEquals("example@email.com", person.getEmail());
    }
}