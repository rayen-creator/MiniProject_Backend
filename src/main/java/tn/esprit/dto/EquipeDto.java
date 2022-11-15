package tn.esprit.dto;

import lombok.*;
import tn.esprit.dao.entities.DetailEquipe;
import tn.esprit.dao.entities.Niveau;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EquipeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    private List<EtudiantDto> etudiants;

    private DetailEquipe detailEquipe;

}
