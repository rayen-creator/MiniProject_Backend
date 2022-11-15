package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dto.ContratDto;
import tn.esprit.service.interfaces.ContratService;
import javax.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratService cServ;

    @GetMapping
    public List<ContratDto> displayAllContrat() {
        return cServ.chercherContratsDto();
    }

    @GetMapping("display/{id}")
    public Optional<ContratDto> displayContratById(@PathVariable("id") int id) {

        return cServ.afficherContratDto(id);
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

    @GetMapping("conByDate/{dateDebut}/{dateFin}")
    public List<ContratDto> displayContratByDate(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {

        return cServ.ContratsValides(dateDebut,dateFin);
    }
    @GetMapping("nbConByDate/{dateDebut}/{dateFin}")
    public Integer displayNbContratByDate(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {

        return cServ.nbContratsValides(dateDebut,dateFin);
    }

    @GetMapping("totalPaid/{dateDebut}/{dateFin}")
    public float displayTotal(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {

        return cServ.getChiffreAffaireEntreDeuxDate(dateDebut,dateFin);
    }
}
