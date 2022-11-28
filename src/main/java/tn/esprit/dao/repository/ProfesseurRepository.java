package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Professeur;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

}
