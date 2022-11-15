package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.DetailEquipe;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.repository.DetailEquipeRepository;
import tn.esprit.service.interfaces.DetailEquipeService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DetailEquipeServiceImpl implements DetailEquipeService {
    @Autowired
    DetailEquipeRepository detailEquipeRep;

    @Override
    public Optional<DetailEquipe> afficherDetailEquipe(int id) {

        DetailEquipe detailEquipe = detailEquipeRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "detailEquipe with Id" + id + " does not exist"
                )
        );
        return detailEquipeRep.findById(id);
    }

    @Override
    public int ajouterDetailEquipe(DetailEquipe d) {
        detailEquipeRep.save(d);
        log.info("Detail "+d.getIdDetailEquipe()+" ajouté avec success");
        return d.getIdDetailEquipe();
    }

    @Override
    public DetailEquipe mettreAjourDetailEquipe(int id) {
        DetailEquipe d = detailEquipeRep.findById(id).get();
        detailEquipeRep.save(d);
        log.info("Detail "+d.getIdDetailEquipe()+" modifié avec success");
        return (d);
    }

    @Override
    public void supprimerDetailEquipe(int id) {
        detailEquipeRep.deleteById(id);
        log.info("detail equipe supprimé");
    }

    @Override
    public List<DetailEquipe> chercherDetailEquipes() {
        List<DetailEquipe> detailEquipes = (List<DetailEquipe>) detailEquipeRep.findAll();
        for(DetailEquipe detailEquipe: detailEquipes) {
            log.info("detail equipe : " + detailEquipe);
        }
        return detailEquipes;
    }
}
