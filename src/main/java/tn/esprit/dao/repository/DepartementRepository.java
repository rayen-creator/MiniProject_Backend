package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
