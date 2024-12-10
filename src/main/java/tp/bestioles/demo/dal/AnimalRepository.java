package tp.bestioles.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.animal;

@Repository
public interface AnimalRepository extends JpaRepository<animal, Integer>{

}
