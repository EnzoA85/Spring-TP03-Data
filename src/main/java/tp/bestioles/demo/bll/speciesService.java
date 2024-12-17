package tp.bestioles.demo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.bestioles.demo.bo.species;
import tp.bestioles.demo.dal.SpeciesRepository;

@Service
public class speciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    // Méthode Create
    public species createSpecies(species newSpecies) {
        return speciesRepository.save(newSpecies);
    }

    // Méthode Update
    public species updateSpecies(Integer id, species updatedSpecies) {
        Optional<species> optionalSpecies = speciesRepository.findById(id);
        if (optionalSpecies.isPresent()) {
            species existingSpecies = optionalSpecies.get();
            existingSpecies.setCommonName(updatedSpecies.getCommonName());
            existingSpecies.setLatinName(updatedSpecies.getLatinName());
            return speciesRepository.save(existingSpecies);
        }
        throw new RuntimeException("Species not found with id: " + id);
    }

    // Méthode GetAll
    public List<species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    // Méthode GetById
    public Optional<species> getSpeciesById(Integer id) {
        return speciesRepository.findById(id);
    }

    // Méthode Delete
    public void deleteSpecies(Integer id) {
        speciesRepository.deleteById(id);
    }
}
