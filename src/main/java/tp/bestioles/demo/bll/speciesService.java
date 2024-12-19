package tp.bestioles.demo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import tp.bestioles.demo.bo.species;
import tp.bestioles.demo.dal.SpeciesRepository;
import tp.bestioles.demo.exception.EntityToCreateHasAnIdException;
import tp.bestioles.demo.exception.EntityToUpdateHasNoIdException;

@Service
public class speciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    // Méthode Create
    public species createSpecies(species newSpecies) {
        if (newSpecies.getId() != null) {
            throw new EntityToCreateHasAnIdException("L'entité à mettre à jour doit avoir un ID.");
        }
        return speciesRepository.save(newSpecies);
    }

    // Méthode Update
    public species updateSpecies(Integer id, species updatedSpecies) {
        if (updatedSpecies.getId() == null) {
            throw new EntityToUpdateHasNoIdException("L'entité à mettre à jour doit avoir un ID.");
        }
        if (!speciesRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal non trouvé avec l'ID: " + id);
        }
        species existingSpecies = speciesRepository.findById(id).orElseThrow();
        existingSpecies.setCommonName(updatedSpecies.getCommonName());
        existingSpecies.setLatinName(updatedSpecies.getCommonName());
        return speciesRepository.save(existingSpecies);
    }

    // Méthode GetAll
    public List<species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    // Méthode GetById
    public Optional<species> getSpeciesById(Integer id) {
        if (!speciesRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal non trouvé avec l'ID: " + id);
        }
        return speciesRepository.findById(id);
    }

    // Méthode Delete
    public void deleteSpecies(Integer id) {
        if (!speciesRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal non trouvé avec l'ID: " + id);
        }
        speciesRepository.deleteById(id);
    }

    public Page<species> findPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return speciesRepository.findAll(pageable);
    }
}
