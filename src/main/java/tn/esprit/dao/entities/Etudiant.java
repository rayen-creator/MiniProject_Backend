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
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    private String Email;
    private String adress;
    private Integer age;
    private Integer phone;
    private String image;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Enumerated(EnumType.STRING)
    private Option option;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private Set<Contrat> Contrat ;
    @JsonIgnore
    @ManyToOne
    Departement departement;
    //@JsonIgnore
    //@ManyToMany(mappedBy="etudiant", cascade = CascadeType.ALL)
    //private List<Equipe> equipe;
    @Override
    public String toString() {
        return "Etudiant [idEtudiant=" + idEtudiant + ", prenomE=" + prenomE + ", nomE=" + nomE + ", dateDebut="
                + dateDebut + ", option=" + option + "]";
    }








}
