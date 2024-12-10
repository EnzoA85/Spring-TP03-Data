package tp.bestioles.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.species;

@Repository
public interface SpeciesRepository extends JpaRepository<species, Integer>{

}
