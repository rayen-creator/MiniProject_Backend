package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Classe;
import tn.esprit.dao.entities.Club;
import tn.esprit.dao.entities.Etudiant;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {


//    @Query("DELETE e FROM Classe e WHERE e.professeur.idProfesseur =:idD")
//    List<Classe> ProfByClass(@Param("idD") Integer idD);


}
