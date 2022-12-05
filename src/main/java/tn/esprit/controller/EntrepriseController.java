package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Entreprise;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.service.interfaces.EntrepriseService;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/entreprise")
public class EntrepriseController {
    @Autowired
    EntrepriseService entpServ;

    @Autowired
    ContratRepository cRep;

    @GetMapping("/Display")
    public List<Entreprise> DisplayAllStudent() {
        return entpServ.chercherEntreprises();
    }


    @PostMapping("/Add")
    public int addEtudiant(@RequestBody Entreprise e){
        return entpServ.ajouterEntreprise(e);
    }

    @GetMapping("/Retrieve/{id}")
    public Entreprise retrieveOperateur(@PathVariable("id") int id) {
        return entpServ.afficherEntreprise(id);
    }

    @DeleteMapping("/Remove/{id}")
    public void removeOperateur(@PathVariable("id") int id) {
        entpServ.supprimerEntreprise(id);
    }


    @PutMapping("/Modify/{id}")
    public Entreprise modifyOperateur(@RequestBody Entreprise e, @PathVariable("id") Integer id ) {
        return entpServ.mettreAjourEntreprise(id,e);
    }

    @PutMapping("assignContrat/{idc}/{nom}")
    public void assignContrat(@PathVariable("idc") Integer idc,@PathVariable("nom") String nom) throws Exception {
        Contrat c = cRep.findById(idc).get();
        entpServ.affectContratToEntreprise(c,nom);
    }


}
