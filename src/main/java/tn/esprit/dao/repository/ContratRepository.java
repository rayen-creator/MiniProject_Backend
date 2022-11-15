package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {


}
