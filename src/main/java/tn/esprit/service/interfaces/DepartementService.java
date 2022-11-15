package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Departement;

import java.util.List;
import java.util.Optional;

public interface DepartementService {
    public Optional<Departement> afficherDepartement(int id);
    public int ajouterDepartement(Departement d);
    public Departement mettreAjourDepartement(int id);
    public void supprimerDepartement(int id);
    public List<Departement> chercherDepartements ();
}
