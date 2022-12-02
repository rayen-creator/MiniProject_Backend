package tn.esprit.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Classe")
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClasse")
    private Integer idClasse; // Clé primaire
    private String nom;


    @ManyToMany
    private List<Etudiant> etudiants;
    @ManyToMany
    private List<Professeur> professeurs;
}
