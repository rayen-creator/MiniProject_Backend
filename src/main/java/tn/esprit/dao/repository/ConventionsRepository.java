package tn.esprit.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dao.entities.Conventions;


@Repository
public interface ConventionsRepository extends JpaRepository<Conventions,Integer> {


}
