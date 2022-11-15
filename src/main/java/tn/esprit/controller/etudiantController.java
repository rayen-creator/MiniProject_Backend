package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.dao.repository.EtudiantRepository;
import tn.esprit.dto.EtudiantDto;
import tn.esprit.service.interfaces.EtudiantService;
import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/etudiant")
public class etudiantController {

    @Autowired
    EtudiantService etudServ;
    @Autowired
    EtudiantRepository etudRep;
    @Autowired
    ContratRepository cRep;

    @GetMapping
    public List<EtudiantDto> displayAllStudent() {
return etudServ.chercherEtudiants();
    }

    @GetMapping("display/{id}")
    public Optional<Etudiant> displayStudentById(@PathVariable("id") int id) {
        return etudServ.afficherEtudiant(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentById(@PathVariable("id") int id) {
        etudServ.supprimerEtudiant(id);
    }

    @PostMapping("/add")
    public int saveStudent(
            @Valid @RequestBody Etudiant etudiant)
    {
        return etudServ.ajouterEtudiant(etudiant);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Etudiant etudiant, @PathVariable Integer id) {
        try {
            Optional<Etudiant> existEtud = etudServ.afficherEtudiant(id);
            etudiant.setIdEtudiant(id);
            etudServ.ajouterEtudiant(etudiant);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("affect/{ide}/{idd}")
    public void affect(@PathVariable("ide") Integer ide,@PathVariable("idd") Integer idd) {
       etudServ.assignEtudiantToDepartement(ide,idd);
    }

    @PutMapping("assign/{id}/{idc}/{ide}")
    public void assign(@PathVariable("id") Integer id,@PathVariable("idc") Integer idc,@PathVariable("ide") Integer ide) {
        Etudiant e = etudRep.findById(id).get();
        etudServ.addAndAssignEtudiantToEquipeAndContract(e,idc,ide);
    }

    @PutMapping("assignContrat/{idc}/{nomE}/{prenomE}")
    public void assignContrat(@PathVariable("idc") Integer idc,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE) throws Exception {
        Contrat c = cRep.findById(idc).get();
        etudServ.affectContratToEtudiant(c,nomE,prenomE);
    }

}
