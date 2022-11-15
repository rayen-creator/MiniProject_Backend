package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Departement;
import tn.esprit.service.interfaces.DepartementService;
import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/departement")
public class departementController {

    @Autowired
    DepartementService depServ;

    @GetMapping
    public List<Departement> displayAllDepartment() {
        return depServ.chercherDepartements();
    }

    @GetMapping("display/{id}")
    public Optional<Departement> displayDepartmentById(@PathVariable("id") int id) {
        return depServ.afficherDepartement(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDepartmentById(@PathVariable("id") int id) {
        depServ.supprimerDepartement(id);
    }

    @PostMapping("/add")
    public int saveDepartment(
            @Valid @RequestBody Departement departement)
    {
        return depServ.ajouterDepartement(departement);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Departement departement, @PathVariable Integer id) {
        try {
            Optional<Departement> existDep = depServ.afficherDepartement(id);
            departement.setIdDepart(id);
            depServ.ajouterDepartement(departement);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
