package tn.esprit.dto;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipeDto implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer idDetailEquipe; // Clé primaire
    private String salle;
    private String thematique;
    private  String description;


}
