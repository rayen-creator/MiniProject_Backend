package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Classe;
import tn.esprit.dao.repository.ClasseRepository;
import tn.esprit.dto.ClasseDto;
import tn.esprit.dto.mapper.ClasseMapper;
import tn.esprit.service.interfaces.ClasseService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClasseServiceImpl implements ClasseService {
    @Autowired
    ClasseRepository classeRep;

    @Autowired
    ClasseMapper classeMapper;
    @Override
    public Optional<Classe> afficherClasse(int id) {

        Classe classe = classeRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "classe with Id: " + id + " does not exist"
                )
        );
        return classeRep.findById(id);
    }

    @Override
    public Optional<ClasseDto> afficherClasseDto(int id) {

        Classe classe = classeRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "classe with Id: " + id + " does not exist"
                )
        );
        ClasseDto classeDto = classeMapper.toDto(classe);
        return Optional.ofNullable(classeDto);
    }

    @Override
    public int ajouterClasse(Classe c) {
        classeRep.save(c);
        log.info("classe "+c.getNom()+" ajouté avec success");
        return c.getIdClasse();
    }

    @Override
    public Classe mettreAjourClasse(int id) {
        Classe c = classeRep.findById(id).get();
        classeRep.save(c);
        log.info("classe "+c.getNom()+" modifié avec success");
        return (c);
    }

    @Override
    public void supprimerClasse(int id) {

        classeRep.deleteById(id);
        log.info("classe supprimé");
    }
    @Override
    public List<ClasseDto> chercherClasses() {
        List<Classe> classes = (List<Classe>) classeRep.findAll();
        List<ClasseDto> classeDtoList = classeMapper.toDtoList(classes);
        for(ClasseDto classe: classeDtoList) {
            log.info("classe : " + classe);
        }
        return classeDtoList;
    }


}
