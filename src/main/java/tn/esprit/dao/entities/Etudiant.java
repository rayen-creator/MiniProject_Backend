package tn.esprit.dao.entities;





import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Temporal (TemporalType.DATE)
    private Date dateDebut;
    @Enumerated(EnumType.STRING)
    private Option option;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private List<Contrat> Contrats;

    @ManyToOne
    Departement departement;



//    @ManyToMany
//    private List<Equipe> equipes;


}
