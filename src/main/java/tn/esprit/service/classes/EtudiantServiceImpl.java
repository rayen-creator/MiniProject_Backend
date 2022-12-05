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
import java.util.Optional;

@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantRepository etuRep;
    @Autowired
    DepartementRepository depRep;
    @Autowired
    ContratRepository conRep;
    @Autowired
    EquipeRepository epRep;

    @Override
    public Etudiant AfficherEtudiant(int id) {
        Etudiant etudiant =(Etudiant) etuRep.findById(id).get();
        log.info("Etudiant :"+ etudiant);

        return etudiant;
    }

    @Override
    public int AjouterEtudiant(Etudiant E) {
        etuRep.save(E);
        log.info(E+"Ajouter avec succee ");
        return E.getIdEtudiant();
    }

    @Override
    public Etudiant MettreAjourEtudiant(Etudiant e) {
        Etudiant etudiant = etuRep.findById(e.getIdEtudiant()).orElse(null);
        if (etudiant != null)
            etuRep.save(e);
        log.info("Mise à jour réussie:"+e );
        return (e);
    }

    @Override
    public void SupprimerEtudiant(int id) {
        etuRep.deleteById(id);
        log.info("supprimé" );
    }

    @Override
    public List<Etudiant> ChecherEtudiant() {

        List<Etudiant> etudiants =(List<Etudiant>) etuRep.findAll();
        for(Etudiant etudiant : etudiants){
            log.info("Etudiant : "+ etudiant);

        }
        return etudiants;
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant e =(Etudiant) etuRep.findById(etudiantId).get();
        Departement d = depRep.findById(departementId).get();
        e.setDepartement(d);
        etuRep.save(e);
        log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+" assigné au departement "+d.getNomDepart());

    }



    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        List<Etudiant> etudiants =  etuRep.EtudByDep(idDepartement);
        return etudiants;
    }

    @Override
    public void affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etuRep.retrieveEtudiantByNomPrenom(nomE, prenomE);
        Integer total = etuRep.countC(e.getIdEtudiant());
        if (total < 5) {
            ce.setEtudiant(e);
            conRep.save(ce);
        }else {
            log.info("etudiant "+e.getPrenomE()+" "+e.getNomE()+"a atteint la limite de contrats actifs !");
        }



    }


}
