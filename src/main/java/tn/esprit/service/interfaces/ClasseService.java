package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Classe;
import tn.esprit.dto.ClasseDto;

import java.util.List;
import java.util.Optional;

public interface ClasseService {
    public Optional<Classe> afficherClasse(int id);

    Optional<ClasseDto> afficherClasseDto(int id);

    public int ajouterClasse(Classe e);
    public Classe mettreAjourClasse(int id);
    public void supprimerClasse(int id);
    public List<ClasseDto> chercherClasses ();


}
