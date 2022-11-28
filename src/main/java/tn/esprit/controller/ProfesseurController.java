package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Professeur;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.dao.repository.ProfesseurRepository;
import tn.esprit.dto.ProfesseurDto;
import tn.esprit.service.interfaces.ProfesseurService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/professeur")
public class ProfesseurController {

    @Autowired
    ProfesseurService profServ;
    @Autowired
    ProfesseurRepository profRep;
    @Autowired
    ContratRepository cRep;

    @GetMapping
    public List<ProfesseurDto> displayAllProfessor() {
        return profServ.chercherProfesseurs();
    }

    @GetMapping("display/{id}")
    public Optional<ProfesseurDto> displayProfessorById(@PathVariable("id") int id) {
        return profServ.afficherProfesseurDto(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProfessorById(@PathVariable("id") int id) {
        profServ.supprimerProfesseur(id);
    }

    @PostMapping("/add")
    public int saveProfessor(
            @Valid @RequestBody Professeur professeur)
    {
        return profServ.ajouterProfesseur(professeur);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Professeur professeur, @PathVariable Integer id) {
        try {
            Optional<Professeur> existEtud = profServ.afficherProfesseur(id);
            professeur.setIdProfesseur(id);
            profServ.ajouterProfesseur(professeur);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
