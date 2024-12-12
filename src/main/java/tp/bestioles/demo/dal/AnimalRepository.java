package tp.bestioles.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.bo.species;

@Repository
public interface AnimalRepository extends JpaRepository<animal, Integer>{
    List<animal> findBySpecies(species species);
    List<animal> findByColorIn(List<String> colors);
}
