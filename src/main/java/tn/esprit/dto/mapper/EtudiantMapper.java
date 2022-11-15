package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;

import tn.esprit.dao.entities.Etudiant;

import tn.esprit.dto.EtudiantDto;

@Mapper(
        componentModel = "spring"
)
public interface EtudiantMapper extends GenericMapper<EtudiantDto, Etudiant> {
}
