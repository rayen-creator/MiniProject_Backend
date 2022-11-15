package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;
import tn.esprit.dao.entities.Universite;
import tn.esprit.dto.UniversiteDto;

@Mapper(
        componentModel = "spring"
)
public interface UniversiteMapper extends GenericMapper<UniversiteDto, Universite> {
}
