package tn.esprit.service.interfaces;


import tn.esprit.dao.entities.Conventions;

import java.util.List;
import java.util.Set;




public interface ConventionsService {
    public Conventions afficherConventions(int id);

    public Integer AjouterConventions(Conventions u);

    public Conventions mettreajourConventions(int id, Conventions c);

    public List<Conventions> afficherToutConventions();

    public void supprimerConventions(int id);

    public Set<Conventions> retrieveConventionsByUniversite(Integer idUniv);
}

