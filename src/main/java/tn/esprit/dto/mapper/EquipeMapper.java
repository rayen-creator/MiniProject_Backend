package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dto.EquipeDto;

@Mapper(
        componentModel = "spring"
)

public interface EquipeMapper extends GenericMapper<EquipeDto, Equipe>{

}
