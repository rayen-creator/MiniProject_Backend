package tn.esprit.service.classes;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Conventions;
import tn.esprit.dao.entities.Universite;
import tn.esprit.dao.repository.ConventionsRepository;
import tn.esprit.dao.repository.UniversiteRepository;
import tn.esprit.service.interfaces.ConventionsService;


@Service
public class ConventionsServiceImpl implements ConventionsService {

    @Autowired
    ConventionsRepository cnvRep;

    @Autowired
    UniversiteRepository unvRep;

    @Override
    public Conventions afficherConventions(int id) {
// TODO Auto-generated method stub

        return cnvRep.findById(id).get();
    }

    @Override
    public Integer AjouterConventions(Conventions c) {
// TODO Auto-generated method stub
        cnvRep.save(c);
        return c.getIdc() ;
    }

    @Override
    public Conventions mettreajourConventions(int id, Conventions c) {
// TODO Auto-generated method stub
        c.setIdc(id);
        cnvRep.save(c);
        return c;
    }


    @Override
    public List<Conventions> afficherToutConventions() {
// TODO Auto-generated method stub

        return cnvRep.findAll();
    }



    @Override
    public void supprimerConventions(int id) {
// TODO Auto-generated method stub
        cnvRep.delete(cnvRep.getById(id));

    }



    @Override
    public Set<Conventions> retrieveConventionsByUniversite(Integer idUniv){
        Optional<Universite> uni = unvRep.findById(idUniv);
        Set<Conventions> listcnv = uni.get().getConventions();
        return listcnv;
    }








}
