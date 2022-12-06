package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Universite;

import java.util.List;


public interface UniversiteService {

    public Universite afficherUniversite(int id);

    public Integer AjouterUniversite(Universite u);

    public Universite mettreajourUniversite(int id, Universite u);

    public List<Universite> afficherToutUniversite();

    public void supprimerUniversite(int id);

    public void assignUniversiteToConvention(Integer idUniv, Integer idc);






}
