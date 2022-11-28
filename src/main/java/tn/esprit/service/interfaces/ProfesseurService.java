package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Professeur;
import tn.esprit.dto.ProfesseurDto;

import java.util.List;
import java.util.Optional;

public interface ProfesseurService {

    public Optional<Professeur> afficherProfesseur(int id);

    Optional<ProfesseurDto> afficherProfesseurDto(int id);

    public int ajouterProfesseur(Professeur p);

    public Professeur mettreAjourProfesseur(int id);

    public void supprimerProfesseur(int id);

    public List<ProfesseurDto> chercherProfesseurs();


}
