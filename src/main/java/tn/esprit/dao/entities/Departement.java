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
@Table( name = "Departement")
public class Departement implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idDepart")
        private Integer idDepart; // Clé primaire
        private String nomDepart;



        @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
        private List<Etudiant> Etudiants;


}


