package tp.bestioles.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.person;

@Repository
public interface PersonRepository extends JpaRepository<person, Integer>, PersonRepositoryCustom{
    
    List<person> findByLastNameOrFirstName(String lastName, String firstName);
    List<person> findByAgeGreaterThanEqual(Integer age);

    @Query(value = "SELECT * FROM person WHERE age BETWEEN :ageMin AND :ageMax", nativeQuery = true)
    List<person> findByAgeBetween(@Param("ageMin") int ageMin, @Param("ageMax") int ageMax);

    @Query("SELECT p FROM person p JOIN p.animalsPerson a WHERE a.name = :animalDonne")
    List<person> findAllPersonPossedeAnimalDonne(@Param("animalDonne") String nameAnimal);
}
