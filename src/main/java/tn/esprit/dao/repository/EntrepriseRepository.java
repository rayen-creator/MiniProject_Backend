package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.dao.entities.Entreprise;


@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer>{
    @Query("SELECT e FROM Entreprise e WHERE e.nom =:nom ")
    Entreprise retrieveEntrepriseByNom(@Param("nom") String nom);
}
