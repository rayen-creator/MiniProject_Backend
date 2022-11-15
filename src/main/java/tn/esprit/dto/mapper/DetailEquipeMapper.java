package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;
import tn.esprit.dao.entities.DetailEquipe;
import tn.esprit.dto.DetailEquipeDto;

@Mapper(
        componentModel = "spring"
)
public interface DetailEquipeMapper extends GenericMapper<DetailEquipeDto, DetailEquipe> {
}
