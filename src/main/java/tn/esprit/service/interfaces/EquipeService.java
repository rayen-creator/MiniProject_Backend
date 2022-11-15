package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Equipe;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dto.EquipeDto;

import java.util.List;
import java.util.Optional;

public interface EquipeService {

    public Optional<Equipe> afficherEquipe(int id);

    Optional<EquipeDto> afficherEquipeDto(int id);

    public int ajouterEquipe(Equipe e);
    public Equipe mettreAjourEquipe(int id);
    public void supprimerEquipe(int id);
    public List<EquipeDto> chercherEquipes ();
}
