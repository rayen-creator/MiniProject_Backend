package tn.esprit.controller;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.dao.entities.Conventions;
import tn.esprit.dao.entities.Universite;
import tn.esprit.service.interfaces.ConventionsService;
import tn.esprit.service.interfaces.UniversiteService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/Universite")
public class UniversiteController {

    @Autowired
    UniversiteService unvServ;

    @Autowired
    ConventionsService cnvServ;


    @GetMapping("/all")
    public List<Universite> displayAllUniversite() {
        return unvServ.afficherToutUniversite();
    }

    @PostMapping("/addUniversity")
    public Integer addUniversite(@RequestBody Universite u) {
        return unvServ.AjouterUniversite(u);
    }

    @PutMapping("/updateUniversity/{idUniv}")
    public Universite updateUniversite(@PathVariable("idUniv") int id, @RequestBody Universite u) {
        return unvServ.mettreajourUniversite( id , u);
    }

    @GetMapping("/University/{idUniv}")
    public Universite Universite(@PathVariable("idUniv") int id ) {
        return unvServ.afficherUniversite( id);
    }

    @DeleteMapping("/deleteU/{idUniv}")
    public void delete(@PathVariable("idUniv") int id) {
        unvServ. supprimerUniversite( id);
    }



    @GetMapping("cnvByUni/{id}")
    public Set<Conventions> displayCnvByUni(@PathVariable("id") int id) {

        return cnvServ.retrieveConventionsByUniversite(id);
    }

    @PostMapping("/affect/{idUniv}/{idc}")
    public void affect(@PathVariable("idUniv") Integer idUniv,@PathVariable("idc")Integer idc) {
        unvServ.assignUniversiteToConvention(idUniv, idc);
    }
}
