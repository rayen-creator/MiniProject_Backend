package tn.esprit.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

    @Entity
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Table( name = "Contrat")
    public class Contrat implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idContrat")
        private Integer idContrat; // Clé primaire
        @Temporal (TemporalType.DATE)
        private Date dateDebutContrat;
        @Temporal (TemporalType.DATE)
        private Date dateFinContrat;
        private Boolean archive;
        private Integer montantContrat;
        @Enumerated(EnumType.STRING)
        private Specialite specialite;


        @ManyToOne
        Etudiant etudiant;
    }
