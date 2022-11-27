package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Club;
import tn.esprit.dao.repository.ClubRepository;
import tn.esprit.dto.ClubDto;
import tn.esprit.service.interfaces.ClubService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/club")
public class ClubController {

    @Autowired
    ClubService clubServ;
    @Autowired
    ClubRepository clubRep;


    @GetMapping
    public List<ClubDto> displayAllClub() {
        return clubServ.chercherClubs();
    }

    @GetMapping("display/{id}")
    public Optional<ClubDto> displayClubById(@PathVariable("id") int id) {
        return clubServ.afficherClubDto(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteClubById(@PathVariable("id") int id) {
        clubServ.supprimerClub(id);
    }

    @PostMapping("/add")
    public int saveClub(
            @Valid @RequestBody Club club)
    {
        return clubServ.ajouterClub(club);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Club club, @PathVariable Integer id) {
        try {
            Optional<Club> existClub = clubServ.afficherClub(id);
            club.setIdClub(id);
            clubServ.ajouterClub(club);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
