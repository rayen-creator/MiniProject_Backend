package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;

import tn.esprit.dao.entities.Etudiant;

import tn.esprit.dao.entities.Professeur;
import tn.esprit.dto.EtudiantDto;
import tn.esprit.dto.ProfesseurDto;

@Mapper(
        componentModel = "spring"
)
public interface ProfesseurMapper extends GenericMapper<ProfesseurDto, Professeur> {
}
