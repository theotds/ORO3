package com.educationalconference.Repositories;

import com.educationalconference.Entities.ConferenceRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ConferenceRoomRepository extends JpaRepository<ConferenceRoom, Long> {
    // Standard CRUD operations provided by JpaRepository
    List<ConferenceRoom> findAll();
}