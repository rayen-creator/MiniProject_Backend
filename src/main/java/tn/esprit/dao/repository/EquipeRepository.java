package tn.esprit.dao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable);
    Page<Equipe> findAll(Pageable pageable);
}
