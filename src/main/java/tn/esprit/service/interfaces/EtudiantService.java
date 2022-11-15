package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dto.EtudiantDto;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    public Optional<Etudiant> afficherEtudiant(int id);
    public int ajouterEtudiant(Etudiant e);
    public Etudiant mettreAjourEtudiant(int id);
    public void supprimerEtudiant(int id);
    public List<EtudiantDto> chercherEtudiants ();

   public void assignEtudiantToDepartement(Integer etudiantId, Integer
            departementId) ;

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);



    public void affectContratToEtudiant(Contrat ce, String nomE, String prenomE) throws Exception;
}
