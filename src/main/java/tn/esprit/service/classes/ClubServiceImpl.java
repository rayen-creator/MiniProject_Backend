package tn.esprit.service.classes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.dao.entities.Club;
import tn.esprit.dao.entities.Contrat;
import tn.esprit.dao.entities.Departement;
import tn.esprit.dao.entities.Equipe;
import tn.esprit.dao.repository.ClubRepository;
import tn.esprit.dto.ClubDto;
import tn.esprit.dto.mapper.ClubMapper;
import tn.esprit.service.interfaces.ClubService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClubServiceImpl implements ClubService {
    @Autowired
    ClubRepository clubRep;

    @Autowired
    ClubMapper clubMapper;
    @Override
    public Optional<Club> afficherClub(int id) {

        Club club = clubRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "club with Id: " + id + " does not exist"
                )
        );
        return clubRep.findById(id);
    }

    @Override
    public Optional<ClubDto> afficherClubDto(int id) {

        Club club = clubRep.findById(id).orElseThrow(() -> new RuntimeException(
                        "club with Id: " + id + " does not exist"
                )
        );
        ClubDto clubDto = clubMapper.toDto(club);
        return Optional.ofNullable(clubDto);
    }

    @Override
    public int ajouterClub(Club c) {
        clubRep.save(c);
        log.info("club "+c.getNom()+" ajouté avec success");
        return c.getIdClub();
    }

    @Override
    public Club mettreAjourClub(int id) {
        Club c = clubRep.findById(id).get();
        clubRep.save(c);
        log.info("club "+c.getNom()+" modifié avec success");
        return (c);
    }

    @Override
    public void supprimerClub(int id) {

        clubRep.deleteById(id);
        log.info("club supprimé");
    }
    @Override
    public List<ClubDto> chercherClubs() {
        List<Club> clubs = (List<Club>) clubRep.findAll();
        List<ClubDto> clubDtoList = clubMapper.toDtoList(clubs);
        for(ClubDto club: clubDtoList) {
            log.info("club : " + club);
        }
        return clubDtoList;
    }


}
