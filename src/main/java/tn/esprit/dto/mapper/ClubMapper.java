package tn.esprit.dto.mapper;

import org.mapstruct.Mapper;
import tn.esprit.dao.entities.Club;
import tn.esprit.dto.ClubDto;

@Mapper(
        componentModel = "spring"
)
public interface ClubMapper extends GenericMapper<ClubDto, Club> {
}
