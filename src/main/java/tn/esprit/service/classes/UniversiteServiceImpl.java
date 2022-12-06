package tn.esprit.service.classes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Conventions;
import tn.esprit.dao.entities.Universite;
import tn.esprit.dao.repository.ConventionsRepository;
import tn.esprit.dao.repository.UniversiteRepository;
import tn.esprit.service.interfaces.ConventionsService;
import tn.esprit.service.interfaces.UniversiteService;


@Service
public class UniversiteServiceImpl  implements UniversiteService {

    @Autowired
    UniversiteRepository unvRep;

    @Autowired
    ConventionsRepository cnvRep;

    @Autowired
    UniversiteRepository universiteRepository;

    @Autowired
    ConventionsService cnvServ;


    @Override
    public Universite afficherUniversite(int id) {
// TODO Auto-generated method stub

        return unvRep.findById(id).get();
    }

    @Override
    public Integer AjouterUniversite(Universite u) {
// TODO Auto-generated method stub
        unvRep.save(u);
        return u.getIdUniv() ;
    }

    @Override
    public Universite mettreajourUniversite(int id, Universite u) {
// TODO Auto-generated method stub
        u.setIdUniv(id);
        unvRep.save(u);
        return u;
    }


    @Override
    public List<Universite> afficherToutUniversite() {
// TODO Auto-generated method stub

        return unvRep.findAll();
    }

    @Override
    public void supprimerUniversite(int id) {
// TODO Auto-generated method stub
        unvRep.delete(unvRep.getById(id));

    }


    @Override
    public void assignUniversiteToConvention(Integer idUniv, Integer idc) {
        Universite u = unvRep.findById(idUniv).get();
        Conventions d =cnvRep.findById(idc).get();
        u.getConventions().add(d);
        unvRep.save(u);
    }




}
