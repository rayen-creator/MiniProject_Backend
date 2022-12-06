package tn.esprit.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Mission")
public class Mission implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idMission")
	private int idMission ; 
	private String title;
	private int duration;
	private String technologies;
	private String description; 
	
	@ManyToOne
	private Contrat contrat;

	public Mission() {
		super();
	}

	public Mission(int idMission, String title, int duration, String technologies, String description,
			Contrat contrat) {
		super();
		this.idMission = idMission;
		this.title = title;
		this.duration = duration;
		this.technologies = technologies;
		this.description = description;
		this.contrat = contrat;
	}

	public int getIdMission() {
		return idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@Override
	public String toString() {
		return "Mission [idMission=" + idMission + ", title=" + title + ", duration=" + duration + ", technologies="
				+ technologies + ", description=" + description + ", contrat=" + contrat + "]";
	}
	
	


}
