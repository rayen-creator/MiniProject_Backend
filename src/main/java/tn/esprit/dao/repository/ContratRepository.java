package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Etudiant;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {
	
	@Modifying
	@Transactional
	@Query("update  Contrat as c set c.etudiant.idEtudiant= :idetudiant where c.idContrat= :idcontrat")
	int affecterContratToEtudiant(@Param("idetudiant") int i, @Param("idcontrat") int j ); 

    @Query("SELECT c FROM Contrat c WHERE c.dateFinContrat between :startDate and :endDate")
    List<Contrat> ContratValideByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
