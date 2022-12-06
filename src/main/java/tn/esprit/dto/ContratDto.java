package tn.esprit.dto;

import lombok.*;
import tn.esprit.dao.entities.Specialite;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;




public class ContratDto implements Serializable {
    

    private Integer idContrat; // Clé primaire
    @Temporal (TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal (TemporalType.DATE)
    private Date dateFinContrat;
    private Boolean archive;
    private Integer montantContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
	

public ContratDto(int idContrat, Date dateDebutContrat, Date dateFinContrat, Specialite specialite, Boolean archive,
		Integer montantContrat) {
	super();
	this.idContrat = idContrat;
	this.dateDebutContrat = dateDebutContrat;
	this.dateFinContrat = dateFinContrat;
	this.specialite = specialite;
	this.archive = archive;
	this.montantContrat = montantContrat;
	
}



public ContratDto() {

}




public int getIdContrat() {
	return idContrat;
}




public void setIdContrat(int idContrat) {
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




public Specialite getSpecialite() {
	return specialite;
}




public void setSpecialite(Specialite specialite) {
	this.specialite = specialite;
}




public Boolean getArchive() {
	return archive;
}




public void setArchive(Boolean archive) {
	this.archive = archive;
}




public int getMontantContrat() {
	return montantContrat;
}




public void setMontantContrat(int montantContrat) {
	this.montantContrat = montantContrat;
}






@Override
public String toString() {
	return "Contrat [idContrat=" + idContrat + ", dateDebutContrat=" + dateDebutContrat + ", dateFinContrat="
			+ dateFinContrat + ", specialite=" + specialite + ", archive=" + archive + ", montantContrat="
			+ montantContrat + "]";
}
    


}
