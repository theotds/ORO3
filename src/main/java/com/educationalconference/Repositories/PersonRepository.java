package com.educationalconference.Repositories;

import com.educationalconference.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Fetch all participants
    List<Person> findAll();

    // Fetch participants by their role
    List<Person> findByRole(String role);

    // Fetch participants by country, with counts
    @Query("SELECT p.country, COUNT(p) FROM Person p GROUP BY p.country")
    List<Object[]> countParticipantsByCountry();

    // Find the person with the most presentations
    @Query("SELECT p FROM Person p JOIN p.presentations pres GROUP BY p.id ORDER BY COUNT(pres) DESC")
    List<Person> findPersonWithMostPresentations();
}