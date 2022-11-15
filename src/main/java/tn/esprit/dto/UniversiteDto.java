package tn.esprit.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;



@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UniversiteDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idUniv; // Clé primaire
    private String nomUniv;

    private List<DepartementDto> Departements;
}
