package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Professeur;
import tn.esprit.dao.repository.ProfesseurRepository;
import tn.esprit.dto.ProfesseurDto;
import tn.esprit.dto.mapper.ProfesseurMapper;
import tn.esprit.service.interfaces.ProfesseurService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfesseurServiceImpl implements ProfesseurService {
    @Autowired
    ProfesseurRepository profRep;

    @Autowired
    ProfesseurMapper profMap;

    @Override
    public Optional<Professeur> afficherProfesseur(int id) {

        Professeur professor = profRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "professor with Id: " + id + " does not exist"
                )
        );
        return profRep.findById(id);
    }

    @Override
    public Optional<ProfesseurDto> afficherProfesseurDto(int id) {

        Professeur professor = profRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "professor with Id: " + id + " does not exist"
                )
        );
        ProfesseurDto professeurDto = profMap.toDto(professor);
        return Optional.ofNullable(professeurDto);
    }

    @Override
    public int ajouterProfesseur(Professeur p) {
        profRep.save(p);
        log.info("professeur "+p.getPrenomProf()+" "+p.getNomProf()+" ajouté avec success");
        return p.getIdProfesseur();
    }

    @Override
    public Professeur mettreAjourProfesseur(int id) {
        Professeur p = profRep.findById(id).get();
        profRep.save(p);
        log.info("professeur "+p.getPrenomProf()+" "+p.getNomProf()+" modifié avec success");
        return (p);
    }

    @Override
    public void supprimerProfesseur(int id) {

        profRep.deleteById(id);
        log.info("professeur supprimé");
    }

    @Override
    public List<ProfesseurDto> chercherProfesseurs() {
        List<Professeur> professeurs = (List<Professeur>) profRep.findAll();
        List<ProfesseurDto> professeurDtoList = profMap.toDtoList(professeurs);
        for(ProfesseurDto professeur: professeurDtoList) {
            log.info("professeur : " + professeur);
        }
        return professeurDtoList;
    }



}
