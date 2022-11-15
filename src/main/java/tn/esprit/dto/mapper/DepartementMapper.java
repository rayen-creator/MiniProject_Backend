package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dto.DepartementDto;

@Mapper(
        componentModel = "spring"
)
public interface DepartementMapper  extends GenericMapper<DepartementDto, Departement> {
}
