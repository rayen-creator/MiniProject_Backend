package tn.esprit.dto;


import lombok.*;
import tn.esprit.dao.entities.Option;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    private String image;
    @Temporal (TemporalType.DATE)
    private Date dateDebut;
    @Enumerated(EnumType.STRING)
    private Option option;

    private List<ContratDto> Contrats;
    private DepartementDto departement;
}
