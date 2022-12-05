package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Classe;
import tn.esprit.dao.repository.ClasseRepository;
import tn.esprit.dto.ClasseDto;
import tn.esprit.service.interfaces.ClasseService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    ClasseService classeServ;
    @Autowired
    ClasseRepository classeRep;


    @GetMapping
    public List<ClasseDto> displayAllClasse() {
        return classeServ.chercherClasses();
    }

    @GetMapping("display/{id}")
    public Optional<ClasseDto> displayClasseById(@PathVariable("id") int id) {
        return classeServ.afficherClasseDto(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteClasseById(@PathVariable("id") int id) {
        classeServ.supprimerClasse(id);
    }


    @PostMapping("/add")
    public int saveClasse(
            @Valid @RequestBody Classe classe) {
        return classeServ.ajouterClasse(classe);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Classe classe, @PathVariable Integer id) {
        try {
            Optional<Classe> existClasse = classeServ.afficherClasse(id);
            classe.setIdClasse(id);
            classeServ.ajouterClasse(classe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
