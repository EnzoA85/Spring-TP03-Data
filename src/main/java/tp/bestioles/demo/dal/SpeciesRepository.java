package tp.bestioles.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.species;

@Repository
public interface SpeciesRepository extends JpaRepository<species, Integer>{
    List<species> findFirstByCommonName(String commonName);
    List<species> findByLatinNameContainingIgnoreCase(String latinName);
}
