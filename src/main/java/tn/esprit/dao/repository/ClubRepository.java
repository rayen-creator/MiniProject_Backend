package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

}
