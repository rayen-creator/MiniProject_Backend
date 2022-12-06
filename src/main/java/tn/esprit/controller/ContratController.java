package tn.esprit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dto.ContratDto;
import tn.esprit.service.interfaces.ContratService;
import javax.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratService cServ;

    @GetMapping
    public List<Contrat> displayAllContrat() {
    	System.out.println("Last     "+cServ.chercherContratsDto());
        return cServ.chercherContratsDto();
    }

    @GetMapping("display/{id}")
    public Contrat displayContratById(@PathVariable("id") int id) {

        return cServ.afficherContrat(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteContratById(@PathVariable("id") int id) {
        cServ.supprimerContrat(id);
    }

    @PostMapping("/add")
    public int saveContrat(
            @Valid @RequestBody Contrat contrat)
    {
        return cServ.ajouterContrat(contrat);
    }

    @PutMapping("update")
    public Contrat update(@Valid @RequestBody Contrat contrat) {
        
        	return cServ.mettreAjourContrat(contrat);
    }
    
    
	@GetMapping("addcontratToEtudiant/{idetudiant}/{idcontrat}")
	public int addcontratToEtudiant(@PathVariable("idetudiant") int idetudiant,@PathVariable("idcontrat") int idc) {;
	/*
	Etudiant e = etudrep.findById(idetudiant).get();
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost("smtp.gmail.com");
	mailSender.setPort(465);
	
	mailSender.setUsername(sender);
	mailSender.setPassword(password);
	 
	Properties properties = new Properties();
	properties.setProperty("mail.smtp.auth", "true");
	properties.setProperty("mail.smtp.starttls.enable", "true");
	 
	mailSender.setJavaMailProperties(properties);
	
	SimpleMailMessage message = new SimpleMailMessage();
	 
	message.setFrom(sender);
	message.setTo("emna.taalouch@esprit.tn");
	message.setSubject("Affectation d'un contrat");
	message.setText("Bonjour"+e.getPrenomE()+" "+e.getNomE()+", on vous a affecté le contrat de l'id: "+idc);
	 
	mailSender.send(message);
   */
		return cServ.affecterContratToEtudiant(idetudiant,idc);
	}

    @GetMapping("conByDate/{dateDebut}/{dateFin}")
    public List<ContratDto> displayContratByDate(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {

        return cServ.ContratsValides(dateDebut,dateFin);
    }
    @GetMapping("nbConByDate/{dateDebut}/{dateFin}")
    public Integer displayNbContratByDate(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {

        return cServ.nbContratsValides(dateDebut,dateFin);
    }

    @GetMapping("totalPaid/{dateDebut}/{dateFin}")
    public float displayTotal(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {

        return cServ.getChiffreAffaireEntreDeuxDate(dateDebut,dateFin);
    }
}
