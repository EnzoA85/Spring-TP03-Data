package tp.bestioles.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.bo.person;
import tp.bestioles.demo.bo.species;

@Repository
public interface AnimalRepository extends JpaRepository<animal, Integer>{
    List<animal> findBySpecies(species species);
    List<animal> findByColorIn(List<String> colors);

    @Query(value = "SELECT COUNT(*) FROM animal WHERE sex = :sex", nativeQuery = true)
    Integer findBySex(@Param("sex") String sex);

    @Query("SELECT p FROM person p JOIN p.animalsPerson a WHERE a.name = :animalDonne")
    List<person> findAllPersonPossedeAnimalDonne(@Param("animalDonne") String nameAnimal);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
       "FROM person p JOIN p.animalsPerson a WHERE a.name = :animalDonne")
    boolean findDoesAnimalBelongToAnyPerson(@Param("animalDonne") String nameAnimal);
}
