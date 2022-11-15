package tn.esprit.service.interfaces;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dto.ContratDto;

import java.util.List;
import java.util.Optional;

public interface ContratService {
    public Optional<Contrat> afficherContrat(int id);

    Optional<ContratDto> afficherContratDto(int id);

    public int ajouterContrat(Contrat c);
    public Contrat mettreAjourContrat(int id);
    public void supprimerContrat(int id);
    public List<Contrat> chercherContrats ();

    List<ContratDto> chercherContratsDto();

    @Scheduled(cron="* * 13 * * *")
    String retrieveAndUpdateStatusContrat();
}
