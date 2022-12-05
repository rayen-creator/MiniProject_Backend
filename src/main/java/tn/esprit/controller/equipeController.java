package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.DetailEquipe;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dto.EquipeDto;
import tn.esprit.service.interfaces.DetailEquipeService;
import tn.esprit.service.interfaces.EquipeService;
import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/equipe")
public class equipeController {

    @Autowired
    EquipeService equipeServ;
    @Autowired
    DetailEquipeService detServ;

    @GetMapping
    public List<EquipeDto> displayAllTeams() {
        return equipeServ.chercherEquipes();
    }

    @GetMapping("page")
    public Page<Equipe> displayAllTeamsPage(Pageable pageable) { return equipeServ.chercherEquipesList(pageable);}
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
//    @PutMapping("assignToDetail/{idE}/{idD}")
//    public void assignEquipeToDetail(@PathVariable("idE") Integer idE,@PathVariable("idD") Integer idD){
//        equipeServ.assignEquipeToDetail(idE,idD);
//    }
    @PutMapping("Upgrade")
    public void Upgrade() {
        equipeServ.faireEvoluerEquipes();
    }
    @PutMapping("addDetails/{id}")
    public void saveDetailsTeam(
            @Valid @RequestBody DetailEquipe detailEquipe, @PathVariable Integer id)
    {
        detServ.ajouterDetailEquipe(detailEquipe);

        equipeServ.assignEquipeToDetail(id,detailEquipe);

    }

    @GetMapping("/search/{nomEquipe}")
    public ResponseEntity<?> searchByNomEquipe(@PathVariable String nomEquipe, @PageableDefault(sort = "nomEquipe", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Equipe> equipePage = equipeServ.findAllByNomEquipeContaining(nomEquipe, pageable);

        return new ResponseEntity<>(equipePage, HttpStatus.OK);
    }

}
