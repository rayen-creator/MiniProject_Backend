package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.Universite;

import java.util.List;
import java.util.Optional;

public interface UniversiteService {
    public Optional<Universite> afficherUniversite(int id);
    public int ajouterUniversite(Universite u);
    public Universite mettreAjourUniversite(int id);
    public void supprimerUniversite(int id);
    public List<Universite> chercherUniversites ();

   public void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
