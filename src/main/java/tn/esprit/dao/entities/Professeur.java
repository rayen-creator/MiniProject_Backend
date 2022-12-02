package tn.esprit.dao.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Professeur")
public class Professeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProfesseur")
    private Integer idProfesseur; // Clé primaire
    private String nomProf;
    private String prenomProf;
    private String addresse;
    private Integer age;
    private String phone;
    private String email;
    private String image;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Contrat> Contrats;




}
