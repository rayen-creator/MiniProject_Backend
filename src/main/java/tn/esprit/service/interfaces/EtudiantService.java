package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dto.EtudiantDto;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    public Etudiant AfficherEtudiant(int id);
    public int AjouterEtudiant(Etudiant E);
    public Etudiant MettreAjourEtudiant(Etudiant E);
    public void SupprimerEtudiant(int id);
    public List<Etudiant> ChecherEtudiant();

    public void assignEtudiantToDepartement(Integer etudiantId, Integer  departementId) ;

    public  List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
    public void affectContratToEtudiant(Contrat ce, String nomE, String prenomE) ;
}
