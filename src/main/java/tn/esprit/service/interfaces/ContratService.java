package tn.esprit.service.interfaces;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dto.ContratDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ContratService {
    public Contrat afficherContrat(int id);

    List<Contrat> afficherContratDto(int id);

    public int ajouterContrat(Contrat c);
    public Contrat mettreAjourContrat(Contrat c);
    public void supprimerContrat(int id);
    public List<Contrat> chercherContrats ();

    List<Contrat> chercherContratsDto();

    @Scheduled(cron="* * 13 * * *")
     public String retrieveAndUpdateStatusContrat();
    
    public int affecterContratToEtudiant(int i,int idc);

    public List<ContratDto> ContratsValides(Date startDate, Date endDate);
    public  Integer nbContratsValides(Date startDate, Date endDate);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
}
