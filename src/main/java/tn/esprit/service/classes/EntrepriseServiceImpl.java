package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Entreprise;
import tn.esprit.dao.repository.ContratRepository;
import tn.esprit.dao.repository.EntrepriseRepository;
import tn.esprit.service.interfaces.EntrepriseService;

import java.util.List;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    EntrepriseRepository entpRep;

    @Autowired
    ContratRepository conRep;


    @Override
    public Entreprise afficherEntreprise(int id) {
        Entreprise e =(Entreprise) entpRep.findById(id).get();
        log.info("Entreprise :"+ e);
        return e;
    }

    @Override
    public int ajouterEntreprise(Entreprise e) {
        entpRep.save(e);
        log.info(e+"Ajouter avec succee ");
        return  e.getIdEntreprise();
    }

    @Override
    public Entreprise mettreAjourEntreprise(int id ,Entreprise e) {
        Entreprise entreprise = entpRep.findById(id).orElse(null);
        if (e != null)
            e.setIdEntreprise(id);
        entpRep.save(e);
        log.info("Mise à jour réussie:"+e );
        return (e);
    }

    @Override
    public void supprimerEntreprise(int id) {
        entpRep.deleteById(id);
        log.info("supprimé" );

    }

    @Override
    public List<Entreprise> chercherEntreprises() {
        List<Entreprise> entreprises =(List<Entreprise>) entpRep.findAll();
        for(Entreprise entreprise : entreprises){
            log.info("Entreprise : "+ entreprise);

        }
        return entreprises;
    }

    @Override
    public void affectContratToEntreprise(Contrat ce, String nom) {
        Entreprise e = entpRep.retrieveEntrepriseByNom(nom);
        ce.setEntreprise(e);
        conRep.save(ce);

    }

}

