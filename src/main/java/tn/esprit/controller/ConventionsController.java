package tn.esprit.controller;


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
import tn.esprit.service.interfaces.ConventionsService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/Conventions")
public class ConventionsController {

    @Autowired
    ConventionsService cnvServ;



    @GetMapping("/all")
    public List<Conventions> displayAllConventions() {
        return cnvServ.afficherToutConventions();
    }

    @PostMapping("/addConventions")
    public Integer addConventions(@RequestBody Conventions u) {
        return cnvServ.AjouterConventions(u);
    }

    @PutMapping("/updateConventions/{idc}")
    public Conventions updateConventions(@PathVariable("idc") int id , @RequestBody Conventions c) {
        return cnvServ.mettreajourConventions( id , c);
    }

    @GetMapping("/Conventions/{idc}")
    public Conventions Conventions(@PathVariable("idc") int id) {
        return cnvServ.afficherConventions( id);
    }

    @DeleteMapping("/delete/{idc}")
    public void delete(@PathVariable("idc") int id) {
        cnvServ. supprimerConventions( id);
    }


}
