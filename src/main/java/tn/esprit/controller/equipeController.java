package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dto.EquipeDto;
import tn.esprit.service.interfaces.EquipeService;
import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/equipe")
public class equipeController {

    @Autowired
    EquipeService equipeServ;

    @GetMapping
    public List<EquipeDto> displayAllTeams() {
        return equipeServ.chercherEquipes();
    }

    @GetMapping("display/{id}")
    public Optional<EquipeDto> displayTeamsById(@PathVariable("id") int id) {
        return equipeServ.afficherEquipeDto(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTeamsById(@PathVariable("id") int id) {
        equipeServ.supprimerEquipe(id);
    }

    @PostMapping("/add")
    public int saveTeams(
            @Valid @RequestBody Equipe equipe)
    {
        return equipeServ.ajouterEquipe(equipe);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Equipe equipe, @PathVariable Integer id) {
        try {
            Optional<Equipe> existEquipe = equipeServ.afficherEquipe(id);
            equipe.setIdEquipe(id);
            equipeServ.ajouterEquipe(equipe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
