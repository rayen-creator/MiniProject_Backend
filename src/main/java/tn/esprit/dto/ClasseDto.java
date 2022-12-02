package tn.esprit.dto;


import lombok.*;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.entities.Professeur;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idClasse; // Clé primaire
    private String nom;

    private List<Etudiant> etudiants;
    private List<Professeur> professeurs;
}
