package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    @Query("SELECT e FROM Etudiant e WHERE e.nomE =:nomE and e.prenomE=:prenomE")
    Etudiant retrieveEtudiantByNomPrenom(@Param("nomE") String nomE, @Param("prenomE") String prenomE);
    @Query("SELECT count(c) FROM Contrat c WHERE c.etudiant.idEtudiant =:idE")
    Integer countC(@Param("idE") Integer idE);
    @Query("SELECT e FROM Etudiant e WHERE e.departement.idDepart =:idD")
    List<Etudiant> EtudByDep(@Param("idD") Integer idD);
}
