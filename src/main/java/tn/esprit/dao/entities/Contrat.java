package tn.esprit.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

    @Entity
    @Table( name = "Contrat")
    public class Contrat implements Serializable {
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
        
        
        @OneToMany(mappedBy = "contrat")
        @JsonIgnore
        private Set<Mission> mission; 



        @ManyToOne
        Etudiant etudiant;

        @JsonIgnore
        @ManyToOne
        Entreprise entreprise;
        

public Contrat(int idContrat, Date dateDebutContrat, Date dateFinContrat, Specialite specialite, Boolean archive,
		int montantContrat, Etudiant etudiant) {
	super();
	this.idContrat = idContrat;
	this.dateDebutContrat = dateDebutContrat;
	this.dateFinContrat = dateFinContrat;
	this.specialite = specialite;
	this.archive = archive;
	this.montantContrat = montantContrat;
	this.etudiant = etudiant;
}




public Contrat() {

}


		public Integer getIdContrat() {
			return idContrat;
		}

		public void setIdContrat(Integer idContrat) {
			this.idContrat = idContrat;
		}

		public Date getDateDebutContrat() {
			return dateDebutContrat;
		}

		public void setDateDebutContrat(Date dateDebutContrat) {
			this.dateDebutContrat = dateDebutContrat;
		}

		public Date getDateFinContrat() {
			return dateFinContrat;
		}

		public void setDateFinContrat(Date dateFinContrat) {
			this.dateFinContrat = dateFinContrat;
		}

		public Boolean getArchive() {
			return archive;
		}

		public void setArchive(Boolean archive) {
			this.archive = archive;
		}

		public Integer getMontantContrat() {
			return montantContrat;
		}

		public void setMontantContrat(Integer montantContrat) {
			this.montantContrat = montantContrat;
		}

		public Specialite getSpecialite() {
			return specialite;
		}

		public void setSpecialite(Specialite specialite) {
			this.specialite = specialite;
		}

		public Etudiant getEtudiant() {
			return etudiant;
		}

		public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
		}

		public Entreprise getEntreprise() {
			return entreprise;
		}

		public void setEntreprise(Entreprise entreprise) {
			this.entreprise = entreprise;
		}
        
		@Override
		public String toString() {
			return "Contrat [idContrat=" + idContrat + ", dateDebutContrat=" + dateDebutContrat + ", dateFinContrat="
					+ dateFinContrat + ", specialite=" + specialite + ", archive=" + archive + ", montantContrat="
					+ montantContrat + ", etudiant=" + etudiant + "]";
		}


    }
