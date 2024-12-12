package tp.bestioles.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.person;

@Repository
public interface PersonRepository extends JpaRepository<person, Integer>{
    
    List<person> findByLastNameOrFirstName(String lastName, String firstName);
    List<person> findByAgeGreaterThanEqual(Integer age);
}
