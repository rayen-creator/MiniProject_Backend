package tn.esprit.dto;


import lombok.*;
import tn.esprit.dao.entities.Etudiant;
import tn.esprit.dao.entities.Option;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ClubDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idClub; // Clé primaire
    private String nom;
    private String logo;
    private String room;
    private String description;
    private String email;
    private String phone;


    private List<EtudiantDto> etudiants;
}
