package com.educationalconference.Repositories;

import com.educationalconference.Entities.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

}
