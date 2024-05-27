package com.educationalconference;
import com.educationalconference.Entities.Participation;
import com.educationalconference.Entities.Person;
import com.educationalconference.Entities.Presentation;
import com.educationalconference.Repositories.PersonRepository;
import com.educationalconference.Repositories.PresentationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PresentationRepository presentationRepository;

    @Test
    public void testFindAllParticipants() {
        Person person1 = new Person("John", "Doe", "scientist", "USA");
        personRepository.save(person1);

        List<Person> persons = personRepository.findAll();
        assertThat(persons).hasSize(1);
    }

    @Test
    public void testFindByRole() {
        Person scientist = new Person("Alice", "Smith", "scientist", "USA");
        personRepository.save(scientist);

        List<Person> scientists = personRepository.findByRole("scientist");
        assertThat(scientists).hasSize(1);
        assertThat(scientists.get(0).getFirstName()).isEqualTo("Alice");
    }

    @Test
    public void testCountParticipantsByCountry() {
        Person person1 = new Person("John", "Doe", "scientist", "USA");
        personRepository.save(person1);

        List<Object[]> results = personRepository.countParticipantsByCountry();
        assertThat(results).hasSize(1);
        assertThat(results.get(0)[0]).isEqualTo("USA");
        assertThat(results.get(0)[1]).isEqualTo(1L);
    }

    @Test
    public void testFindPersonWithMostPresentations() {
        // Create and save a person
        Person person1 = new Person("John", "Doe", "scientist", "USA");
        personRepository.save(person1);

        // Create and save presentations linked to the person
        Presentation pres1 = new Presentation("Climate Change");
        pres1.setPerson(person1); // Assuming setter method sets back-reference correctly
        presentationRepository.save(pres1);

        Presentation pres2 = new Presentation("Global Warming");
        pres2.setPerson(person1);
        presentationRepository.save(pres2);

        // Assuming 'findPersonWithMostPresentations' is correctly implemented in the repository
        List<Person> result = personRepository.findPersonWithMostPresentations();

        assertThat(result).isNotEmpty();
        assertThat(result.get(0)).isEqualTo(person1);
    }
}

