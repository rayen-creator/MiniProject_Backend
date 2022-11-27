package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.DetailEquipe;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dao.repository.DetailEquipeRepository;
import tn.esprit.dao.repository.EquipeRepository;
import tn.esprit.dto.DetailEquipeDto;
import tn.esprit.dto.mapper.DetailEquipeMapper;
import tn.esprit.service.interfaces.DetailEquipeService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DetailEquipeServiceImpl implements DetailEquipeService {
    @Autowired
    DetailEquipeRepository detailEquipeRep;
    @Autowired
    EquipeRepository equipeRep;
    @Autowired
    DetailEquipeMapper detailMapper;

    @Override
    public Optional<DetailEquipe> afficherDetailEquipe(int id) {

        DetailEquipe detailEquipe = detailEquipeRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "detailEquipe with Id" + id + " does not exist"
                )
        );
        return detailEquipeRep.findById(id);
    }

    @Override
    public Optional<DetailEquipeDto> afficherDetailEquipeDto(int id) {

        DetailEquipe dEquipe = detailEquipeRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "equipe with Id" + id + " does not exist"
                )
        );
        DetailEquipeDto dEquipeDto = detailMapper.toDto(dEquipe);
        return Optional.ofNullable(dEquipeDto);
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
    public List<DetailEquipeDto> chercherDetailEquipes() {
        List<DetailEquipe> detailEquipes = (List<DetailEquipe>) detailEquipeRep.findAll();
        List<DetailEquipeDto> detailEquipeDtos = detailMapper.toDtoList(detailEquipes);
        for(DetailEquipeDto detailEquipe: detailEquipeDtos) {
            log.info("detail equipe : " + detailEquipe);
        }
        return detailEquipeDtos;
    }

}
