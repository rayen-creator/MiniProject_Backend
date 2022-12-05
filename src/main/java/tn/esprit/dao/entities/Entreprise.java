package tn.esprit.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Entreprise")
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idEntreprise; // Clé primaire

    private String nom;
    private String adresse;
    private String logo;
    private Integer numFiscal;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entreprise")
    private List<Contrat> Contrat ;
    @Override
    public String toString() {
        return "Entreprise [idEntreprise=" + idEntreprise + ", nom=" + nom + ", adresse=" + adresse + ", numFiscal="
                + numFiscal + "]";
    }




}
