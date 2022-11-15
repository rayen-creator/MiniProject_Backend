package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.DetailEquipe;
import tn.esprit.service.interfaces.DetailEquipeService;
import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/detailEquipe")
public class detailEquipeController {

    @Autowired
    DetailEquipeService detServ;

    @GetMapping
    public List<DetailEquipe> displayAllDetails() {
        return detServ.chercherDetailEquipes();
    }

    @GetMapping("display/{id}")
    public Optional<DetailEquipe> displayDetailsById(@PathVariable("id") int id) {
        return detServ.afficherDetailEquipe(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDetailsById(@PathVariable("id") int id) {
        detServ.supprimerDetailEquipe(id);
    }

    @PostMapping("/add")
    public int saveDetails(
            @Valid @RequestBody DetailEquipe detailEquipe)
    {
        return detServ.ajouterDetailEquipe(detailEquipe);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DetailEquipe detailEquipe, @PathVariable Integer id) {
        try {
            Optional<DetailEquipe> existDet = detServ.afficherDetailEquipe(id);
            detailEquipe.setIdDetailEquipe(id);
            detServ.ajouterDetailEquipe(detailEquipe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
