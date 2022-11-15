package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.DetailEquipe;

import java.util.List;
import java.util.Optional;

public interface DetailEquipeService {

    public Optional<DetailEquipe> afficherDetailEquipe(int id);
    public int ajouterDetailEquipe(DetailEquipe d);
    public DetailEquipe mettreAjourDetailEquipe(int id);
    public void supprimerDetailEquipe(int id);
    public List<DetailEquipe> chercherDetailEquipes ();
}
