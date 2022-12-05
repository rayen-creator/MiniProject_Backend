package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.DetailEquipe;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.repository.DetailEquipeRepository;
import tn.esprit.dao.repository.EquipeRepository;
import tn.esprit.dto.ContratDto;
import tn.esprit.dto.EquipeDto;
import tn.esprit.dto.EtudiantDto;
import tn.esprit.dto.mapper.EquipeMapper;
import tn.esprit.service.interfaces.EquipeService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static tn.esprit.dao.entities.Niveau.EXPERT;
import static tn.esprit.dao.entities.Niveau.SENIOR;

@Service
@Slf4j
public class EquipeServiceImpl implements EquipeService {
    @Autowired
    EquipeRepository equipeRep;
    @Autowired
    DetailEquipeRepository DequipeRep;
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

    @Override
    public Page<Equipe> chercherEquipesList(Pageable pageable) {
       return equipeRep.findAll(pageable);
    }
    @Override
    public void assignEquipeToDetail(Integer equipeId, DetailEquipe detail){
        Equipe e = equipeRep.findById(equipeId).get();

        e.setDetailEquipe(detail);
        equipeRep.save(e);

    }
    @Transactional
    @Override
    public void faireEvoluerEquipes(){
        Long compt = 0L;
        List<Equipe> equipeList = equipeRep.findAll();
        List<EquipeDto> equipeListDto = eqMapper.toDtoList(equipeList);
        for (EquipeDto equipe : equipeListDto) {
            List<EtudiantDto> list = equipe.getEtudiants();
            if (list.stream().count() >= 3) {
                for (EtudiantDto etudiant : list) {
                    List<ContratDto> conList = etudiant.getContrats();
                    for (ContratDto contrat : conList) {
                        long dateBeforeInMs = contrat.getDateDebutContrat().getTime();
                        long dateAfterInMs = contrat.getDateFinContrat().getTime();
                        long timeDiff = Math.abs(dateBeforeInMs - dateAfterInMs);
                        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
                        if (daysDiff>=365)
                        {
                            compt++;
                            if (Objects.equals(equipe.getNiveau().toString(), "JUNIOR") && compt >=1 ){
                                equipe.setNiveau(SENIOR);
                              Equipe Upgraded = eqMapper.toEntity(equipe);
                            } else if (Objects.equals(equipe.getNiveau().toString(), "SENIOR") && compt >=1) {
                                equipe.setNiveau(EXPERT);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable) {
        return equipeRep.findAllByNomEquipeContaining(nomEquipe, pageable);
    }
}
