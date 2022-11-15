package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.service.interfaces.ContratService;
import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratService cServ;

    @GetMapping
    public List<Contrat> displayAllContrat() {
        return cServ.chercherContrats();
    }

    @GetMapping("display/{id}")
    public Optional<Contrat> displayContratById(@PathVariable("id") int id) {
        return cServ.afficherContrat(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteContratById(@PathVariable("id") int id) {
        cServ.supprimerContrat(id);
    }

    @PostMapping("/add")
    public int saveContrat(
            @Valid @RequestBody Contrat contrat)
    {
        return cServ.ajouterContrat(contrat);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Contrat contrat, @PathVariable Integer id) {
        try {
            Optional<Contrat> existC= cServ.afficherContrat(id);
            contrat.setIdContrat(id);
            cServ.ajouterContrat(contrat);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
