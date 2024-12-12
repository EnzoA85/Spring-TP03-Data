package tp.bestioles.demo.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tp.bestioles.demo.bo.species;

@Repository
public interface SpeciesRepository extends JpaRepository<species, Integer>{
    List<species> findFirstByCommonName(String commonName);
    List<species> findByLatinNameContainingIgnoreCase(String latinName);
    
    @Query(value = "SELECT * FROM species ORDER BY common_name asc", nativeQuery = true)
    List<species> findAllByCommonNameAscendingSql();

    @Query(value = "SELECT * FROM species WHERE common_name LIKE %:commonName%", nativeQuery = true)
    List<species> findByCommonNameLike(@Param("commonName") String commonName);
}
