package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.Etudiant;

import java.util.List;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {


}
