package tn.esprit.eventsproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.eventsproject.dao.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}