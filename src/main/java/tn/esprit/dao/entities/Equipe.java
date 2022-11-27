package tn.esprit.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Equipe")
public class Equipe implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idEquipe")
        private Integer idEquipe; // Clé primaire
        private String nomEquipe;
        private String image;
        @Enumerated(EnumType.STRING)
        private Niveau niveau;
        @ManyToMany(cascade = CascadeType.ALL)
        private List<Etudiant> etudiants;
        @OneToOne(cascade = CascadeType.ALL )
        private DetailEquipe detailEquipe;

}
