package tn.esprit.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "DetailEquipe")
public class DetailEquipe implements Serializable{
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idDetailEquipe")
        private Integer idDetailEquipe; // Clé primaire
        private Integer salle;
        private String thematique;
        @OneToOne(mappedBy="detailEquipe")
        private Equipe equipe;

}
