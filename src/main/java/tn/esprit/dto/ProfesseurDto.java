package tn.esprit.dto;


import lombok.*;
import tn.esprit.dao.entities.Contrat;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idProfesseur; // Clé primaire
    private String nomProf;
    private String prenomProf;
    private String addresse;
    private Integer age;
    private String phone;
    private String email;
    private String image;

    private List<Contrat> Contrats;


}
