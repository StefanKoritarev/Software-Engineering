package de.tum.in.ase.eist;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.repository.PersonRepository;
import de.tum.in.ase.eist.service.PersonService;
import org.hibernate.annotations.Parent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void testAddPerson() {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        personService.save(person);

        assertEquals(1, personRepository.findAll().size());
    }

    @Test
    void testDeletePerson() {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        person = personRepository.save(person);

        personService.delete(person);

        assertTrue(personRepository.findAll().isEmpty());
    }

    // TODO: Add more test cases here
    @Test
    void testAddParent(){
        Person child = new Person();
        child.setFirstName("Petar");
        child.setLastName("Golemeca");
        child.setBirthday(LocalDate.now());

        Person parent = new Person();
        parent.setFirstName("Ivan");
        parent.setLastName("Golemeca");
        parent.setBirthday(LocalDate.now());

        child =  personRepository.save(child);
        parent =  personRepository.save(parent);

        child = personService.addParent(child, parent);
        //personService.addChild(child, parent);

        assertEquals(2, personRepository.findAll().size());

        assertTrue(child.getParents().contains(parent));


    }
    @Test
    void testAddThreeParents(){
        Person child = new Person();
        child.setFirstName("Cristiano");
        child.setLastName("Ronaldo");
        child.setBirthday(LocalDate.now());

        Person parent1 = new Person();
        parent1.setFirstName("Gosho");
        parent1.setLastName("Ivanov");
        parent1.setBirthday(LocalDate.now());

        Person parent2 = new Person();
        parent2.setFirstName("Ivan");
        parent2.setLastName("Ivanov");
        parent2.setBirthday(LocalDate.now());

        Person parent3 = new Person();
        parent3.setFirstName("Petranka");
        parent3.setLastName("Ivanova");
        parent3.setBirthday(LocalDate.now());

        child = personRepository.save(child);
        parent1 = personRepository.save(parent1);
        parent2 = personRepository.save(parent2);
        parent3 = personRepository.save(parent3);


         child = personService.addParent(child, parent1);
         child = personService.addParent(child, parent2);

        assertTrue(child.getParents().contains(parent1) && child.getParents().contains(parent2));
        assertEquals(4, personRepository.findAll().size());

        //assertThrows(new ResponseStatusException(HttpStatus.BAD_REQUEST), personService.addParent(child, parent3));


    }

}
