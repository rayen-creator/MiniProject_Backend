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
@Table( name = "Club")
public class Club implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClub")
    private Integer idClub; // Clé primaire
    private String nom;
    private String logo;
    private String room;
    private String description;
    private String email;
    private String phone;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
}
