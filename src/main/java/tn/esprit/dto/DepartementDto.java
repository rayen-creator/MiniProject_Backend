package tn.esprit.dto;


import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class DepartementDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idDepart; // Clé primaire
    private String nomDepart;




}


