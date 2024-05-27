package com.educationalconference.Repositories;

import com.educationalconference.Entities.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    // Fetch all presentation topics
    @Query("SELECT p.title FROM Presentation p")
    List<String> findAllPresentationTopics();

    // Count presentations in each conference room
    @Query("SELECT r.name, COUNT(p) FROM Presentation p JOIN p.conferenceRoom r GROUP BY r.name")
    List<Object[]> countPresentationsByRoom();
}