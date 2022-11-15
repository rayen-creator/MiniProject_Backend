package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dao.repository.EquipeRepository;
import tn.esprit.dto.EquipeDto;
import tn.esprit.dto.EtudiantDto;
import tn.esprit.dto.mapper.EquipeMapper;
import tn.esprit.service.interfaces.EquipeService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EquipeServiceImpl implements EquipeService {
    @Autowired
    EquipeRepository equipeRep;
    @Autowired
    EquipeMapper eqMapper;

    @Override
    public Optional<Equipe> afficherEquipe(int id) {

        Equipe equipe = equipeRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "equipe with Id" + id + " does not exist"
                )
        );
        return equipeRep.findById(id);
    }

    @Override
    public Optional<EquipeDto> afficherEquipeDto(int id) {

        Equipe equipe = equipeRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "equipe with Id" + id + " does not exist"
                )
        );
        EquipeDto equipeDto = eqMapper.toDto(equipe);
        return Optional.ofNullable(equipeDto);
    }


    @Override
    public int ajouterEquipe(Equipe e) {
        equipeRep.save(e);
        log.info("equipe "+e.getNomEquipe()+" ajouté avec success");
        return e.getIdEquipe();
    }

    @Override
    public Equipe mettreAjourEquipe(int id) {
        Equipe e = equipeRep.findById(id).get();
        equipeRep.save(e);
        log.info("equipe "+e.getNomEquipe()+" modifié avec success");
        return (e);
    }

    @Override
    public void supprimerEquipe(int id) {
        equipeRep.deleteById(id);
        log.info("equipe supprimé");
    }

    @Override
    public List<EquipeDto> chercherEquipes() {
        List<Equipe> equipes = (List<Equipe>) equipeRep.findAll();
        List<EquipeDto> equipeDtos = eqMapper.toDtoList(equipes);
        for(EquipeDto equipe: equipeDtos) {
            log.info("equipe : " + equipe);
        }
        return equipeDtos;
    }
}
