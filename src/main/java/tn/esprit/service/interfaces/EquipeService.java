package tn.esprit.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.dao.entities.DetailEquipe;
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

    public Page<Equipe> chercherEquipesList (Pageable pageable);

    void assignEquipeToDetail(Integer equipeId, DetailEquipe detail);

    public void faireEvoluerEquipes();
    Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable);
}
