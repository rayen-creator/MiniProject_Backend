package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.dao.repository.EtudiantRepository;
import tn.esprit.service.interfaces.EtudiantService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/etudiant")
public class etudiantController {

    @Autowired
    EtudiantService etudServ;
    @Autowired
    EtudiantRepository etudRep;
    @Autowired
    ContratRepository cRep;

    @GetMapping("/Display")
    public List<Etudiant> DisplayAllStudent() {
        return etudServ.ChecherEtudiant();
    }


    @PostMapping("/Add")
    public int addEtudiant(@RequestBody Etudiant e){
        return etudServ.AjouterEtudiant(e);
    }

    @GetMapping("/Retrieve/{id}")
    public Etudiant retrieveOperateur(@PathVariable("id") int id) {
        return etudServ.AfficherEtudiant(id);
    }

    @DeleteMapping("/Remove/{id}")
    public void removeOperateur(@PathVariable("id") int id) {
        etudServ.SupprimerEtudiant(id);
    }


    @PutMapping("/Modify/{id}")
    public Etudiant modifyOperateur(@RequestBody Etudiant e, @PathVariable("id") Integer id ) {
// Etudiant etud = etudRep.findById(id).get();
        return etudServ.MettreAjourEtudiant(e);
    }

    @PutMapping("affect/{ide}/{idd}")
    public void affect(@PathVariable("ide") Integer ide,@PathVariable("idd") Integer idd) {
        etudServ.assignEtudiantToDepartement(ide,idd);
    }



    @PutMapping("assignContrat/{idc}/{nomE}/{prenomE}")
    public void assignContrat(@PathVariable("idc") Integer idc,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE) throws Exception {
        Contrat c = cRep.findById(idc).get();
        etudServ.affectContratToEtudiant(c,nomE,prenomE);
    }


    @GetMapping("EtudByDep/{id}")
    public List<Etudiant> EtudByDep(@PathVariable("id") Integer id){
        return etudServ.getEtudiantsByDepartement(id);
    }


}
