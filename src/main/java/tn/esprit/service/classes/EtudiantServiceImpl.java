package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.dao.repository.DepartementRepository;
import tn.esprit.dao.repository.EquipeRepository;
import tn.esprit.dao.repository.EtudiantRepository;
import tn.esprit.dto.EtudiantDto;
import tn.esprit.dto.mapper.EtudiantMapper;
import tn.esprit.service.interfaces.EtudiantService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantRepository etudRep;
    @Autowired
    DepartementRepository depRep;
    @Autowired
    ContratRepository conRep;
    @Autowired
    EquipeRepository eqRep;
    @Autowired
    EtudiantMapper etudMap;
    @Override
    public Optional<Etudiant> afficherEtudiant(int id) {

        Etudiant student = etudRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "student with Id: " + id + " does not exist"
                )
        );
        return etudRep.findById(id);
    }

    @Override
    public int ajouterEtudiant(Etudiant e) {
        etudRep.save(e);
        log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+" ajouté avec success");
        return e.getIdEtudiant();
    }

    @Override
    public Etudiant mettreAjourEtudiant(int id) {
        Etudiant e = etudRep.findById(id).get();
        etudRep.save(e);
        log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+" modifié avec success");
        return (e);
    }

    @Override
    public void supprimerEtudiant(int id) {

        etudRep.deleteById(id);
        log.info("etudiant supprimé");
    }
    @Override
    public List<EtudiantDto> chercherEtudiants() {
        List<Etudiant> etudiants = (List<Etudiant>) etudRep.findAll();
        List<EtudiantDto> etudiantDtoList = etudMap.toDtoList(etudiants);
        for(EtudiantDto etudiant: etudiantDtoList) {
            log.info("etudiant : " + etudiant);
        }
        return etudiantDtoList;
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer
            departementId) {
    Etudiant e = etudRep.findById(etudiantId).get();
        Departement d = depRep.findById(departementId).get();
        e.setDepartement(d);
        etudRep.save(e);
        log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+" assigné au departement "+d.getNomDepart());
    }
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat c = conRep.findById(idContrat).get();
        Equipe eq = eqRep.findById(idEquipe).get();
        c.setEtudiant(e);
        eq.getEtudiants().add(e);
        conRep.save(c);
        eqRep.save(eq);
        return e;
    }
    @Scheduled(fixedRate = 60000)
    public void fixedRateMethod() {
        System.out.println("Method with fixed Rate");
    }

    @Scheduled(fixedDelay = 60000)
    public void fixedDelayMethod() {
        System.out.println("Method with fixed delay");
    }

    @Scheduled(cron = "*/60 * * * * *" )
    public void cronMethod() {
        System.out.println("Method with cron expression");
    }
    @Override
    public void affectContratToEtudiant(Contrat ce, String nomE, String prenomE) throws Exception {
        Etudiant e = etudRep.retrieveEtudiantByNomPrenom(nomE, prenomE);
          Integer total = etudRep.countC(e.getIdEtudiant());
//        EtudiantDto ed = etudMap.toDto(e);
       if (total < 5) {
           ce.setEtudiant(e);
           conRep.save(ce);
       } else {
           log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+"a atteint la limite de contrats actifs !");
           throw new Exception("limite contrats atteint !");
       }

    }
}
