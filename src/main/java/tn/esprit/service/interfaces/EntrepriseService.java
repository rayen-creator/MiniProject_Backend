package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Entreprise;

import java.util.List;

public interface EntrepriseService {
    public Entreprise afficherEntreprise(int id);
    public int ajouterEntreprise(Entreprise e);
    public Entreprise mettreAjourEntreprise(int id,Entreprise e);
    public void supprimerEntreprise(int id);
    public List<Entreprise> chercherEntreprises ();
    public void affectContratToEntreprise(Contrat ce, String nom) ;
}
