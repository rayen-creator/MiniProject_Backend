package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.entities.Universite;
import tn.esprit.dao.repository.DepartementRepository;
import tn.esprit.dao.repository.UniversiteRepository;
import tn.esprit.service.interfaces.UniversiteService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UniversiteServiceImpl implements UniversiteService {
    @Autowired
    UniversiteRepository uniRep;
    @Autowired
    DepartementRepository depRep;

    @Override
    public Optional<Universite> afficherUniversite(int id) {

        Universite university = uniRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "university with Id" + id + " does not exist"
                )
        );
        return uniRep.findById(id);
    }

    @Override
    public int ajouterUniversite(Universite u) {
        uniRep.save(u);
        log.info("universite "+u.getNomUniv()+" ajouté avec success");
        return u.getIdUniv();
    }

    @Override
    public Universite mettreAjourUniversite(int id) {
        Universite u = uniRep.findById(id).get();
        uniRep.save(u);
        log.info("universite "+u.getNomUniv()+" modifié avec success");
        return (u);
    }


    @Override
    public void supprimerUniversite(int id) {
        uniRep.deleteById(id);
        log.info("universite supprimé");
    }

    @Override
    public List<Universite> chercherUniversites() {
        List<Universite> universites = (List<Universite>) uniRep.findAll();
        for(Universite universite: universites) {
            log.info("universite : " + universite);
        }
        return universites;
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement) {
        Universite u = uniRep.findById(idUniversite).get();
        Departement d = depRep.findById(idDepartement).get();
        u.getDepartements().add(d);
        uniRep.save(u);
    }
}
