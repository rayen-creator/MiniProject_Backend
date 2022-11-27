package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.Universite;
import tn.esprit.service.interfaces.UniversiteService;
import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/universite")
public class universiteController {

    @Autowired
    UniversiteService univServ;

    @GetMapping
    public List<Universite> displayAllUni() {
        return univServ.chercherUniversites();
    }

    @GetMapping("display/{id}")
    public Optional<Universite> displayUniById(@PathVariable("id") int id) {
        return univServ.afficherUniversite(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUniById(@PathVariable("id") int id) {
        univServ.supprimerUniversite(id);
    }

    @PostMapping("/add")
    public int saveUni(
            @Valid @RequestBody Universite universite)
    {
        return univServ.ajouterUniversite(universite);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Universite universite, @PathVariable Integer id) {
        try {
            Optional<Universite> existUni = univServ.afficherUniversite(id);
            universite.setIdUniv(id);
            univServ.ajouterUniversite(universite);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("affect/{idu}/{idd}")
    public void affect(@PathVariable("idu") Integer idu,@PathVariable("idd") Integer idd) {
        univServ.assignUniversiteToDepartement(idu,idd);
    }

    @GetMapping("depByUni/{id}")
    public List<Departement> displayDepByUni(@PathVariable("id") int id) {

        return univServ.retrieveDepartementsByUniversite(id);
    }
}
