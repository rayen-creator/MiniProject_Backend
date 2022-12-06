package tn.esprit.dao.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Universite")
public class Universite implements Serializable  {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="idUniv")
        public Integer idUniv;
        public String nomUniv;
        public String emplacement ;
        public Date date_fondation;
        public String description;
        public String img;
        public String accrediation;
        @OneToMany(cascade=CascadeType.ALL)
        private Set<Departement> Departement;
        @OneToMany(cascade=CascadeType.ALL)
        private Set<Conventions> Conventions;

}
