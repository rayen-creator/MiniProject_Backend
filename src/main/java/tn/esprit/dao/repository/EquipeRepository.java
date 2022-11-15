package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Equipe;

import java.util.Date;
import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

}
