package tn.esprit.service.interfaces;

import tn.esprit.dao.entities.Club;
import tn.esprit.dto.ClubDto;

import java.util.List;
import java.util.Optional;

public interface ClubService {
    public Optional<Club> afficherClub(int id);

    Optional<ClubDto> afficherClubDto(int id);

    public int ajouterClub(Club e);
    public Club mettreAjourClub(int id);
    public void supprimerClub(int id);
    public List<ClubDto> chercherClubs ();


}
