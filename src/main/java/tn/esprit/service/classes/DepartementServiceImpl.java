package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.repository.DepartementRepository;
import tn.esprit.service.interfaces.DepartementService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartementServiceImpl implements DepartementService {
    @Autowired
    DepartementRepository depRep;

    @Override
    public Optional<Departement> afficherDepartement(int id) {

        Departement department = depRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "department with Id" + id + " does not exist"
                )
        );
        return depRep.findById(id);
    }

    @Override
    public int ajouterDepartement(Departement e) {
        depRep.save(e);
        log.info("departement "+e.getNomDepart()+" ajouté avec success");
        return e.getIdDepart();
    }

    @Override
    public Departement mettreAjourDepartement(int id) {
        Departement e = depRep.findById(id).get();
        depRep.save(e);
        log.info("departement "+e.getNomDepart()+" modifié avec success");
        return (e);
    }

    @Override
    public void supprimerDepartement(int id) {
        depRep.deleteById(id);
        log.info("departement supprimé");
    }

    @Override
    public List<Departement> chercherDepartements() {
        List<Departement> departements = (List<Departement>) depRep.findAll();
        for(Departement departement: departements) {
            log.info("departement : " + departement);
        }
        return departements;
    }
}
