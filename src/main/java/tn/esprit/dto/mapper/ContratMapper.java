package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dto.ContratDto;

@Mapper(
        componentModel = "spring"
)

public interface ContratMapper extends GenericMapper<ContratDto, Contrat> {

}
