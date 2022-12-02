package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;
import tn.esprit.dao.entities.Classe;
import tn.esprit.dto.ClasseDto;

@Mapper(
        componentModel = "spring"
)
public interface ClasseMapper extends GenericMapper<ClasseDto, Classe> {
}
