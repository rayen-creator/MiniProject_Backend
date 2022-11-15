package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.service.interfaces.ContratService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContratServiceImpl implements ContratService {
    @Autowired
    ContratRepository cRep;

    @Override
    public Optional<Contrat> afficherContrat(int id) {

        Contrat contrat = cRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "cartment with Id" + id + " does not exist"
                )
        );
        return cRep.findById(id);
    }

    @Override
    public int ajouterContrat(Contrat c) {
        cRep.save(c);
        log.info("contrat "+c.getIdContrat()+" ajouté avec success");
        return c.getIdContrat();
    }

    @Override
    public Contrat mettreAjourContrat(int id) {
        Contrat c = cRep.findById(id).get();
        cRep.save(c);
        log.info("contrat "+c.getIdContrat()+" modifié avec success");
        return (c);
    }

    @Override
    public void supprimerContrat(int id) {
        cRep.deleteById(id);
        log.info("contrat supprimé");
    }

    @Override
    public List<Contrat> chercherContrats() {
        List<Contrat> contrats = (List<Contrat>) cRep.findAll();
        for(Contrat contrat: contrats) {
            log.info("contrat : " + contrat);
        }
        return contrats;
    }
    @Scheduled(cron="* * 13 * * *")
    @Override
    public String retrieveAndUpdateStatusContrat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        List<Contrat> listContrats = this.chercherContrats();
        String result = "";
        for(Contrat c : listContrats) {
            if(c.getDateFinContrat().compareTo(date) == 1) {
                c.setArchive(true);
                this.cRep.save(c);
                result += c.getDateFinContrat() + " "+c.getSpecialite()+ " "+c.getEtudiant();
            }
        }
        return result;
    }

}
