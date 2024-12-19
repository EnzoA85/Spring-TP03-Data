package tp.bestioles.demo.bll;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.dal.AnimalRepository;
import tp.bestioles.demo.dto.AnimalDto;
import tp.bestioles.demo.exception.EntityToCreateHasAnIdException;
import tp.bestioles.demo.exception.EntityToUpdateHasNoIdException;
import tp.bestioles.demo.mapper.AnimalMapper;

@Service
public class animalService {

    @Autowired
    private AnimalRepository animalRepository;

    // Méthode Create
    public animal createAnimal(animal newAnimal) {
        if (newAnimal.getId() != null) {
            throw new EntityToCreateHasAnIdException("L'entité à mettre à jour doit avoir un ID.");
        }
        return animalRepository.save(newAnimal);
    }

    // Méthode Update
    public animal updateAnimal(Integer id, animal updatedAnimal) {
        if (updatedAnimal.getId() == null) {
            throw new EntityToUpdateHasNoIdException("L'entité à mettre à jour doit avoir un ID.");
        }
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal non trouvé avec l'ID: " + id);
        }
        animal existingAnimal = animalRepository.findById(id).orElseThrow();
        existingAnimal.setName(updatedAnimal.getName());
        existingAnimal.setColor(updatedAnimal.getColor());
        existingAnimal.setSex(updatedAnimal.getSex());
        existingAnimal.setSpecies(updatedAnimal.getSpecies());
        return animalRepository.save(existingAnimal);
    }

    // Méthode GetAll
    public List<animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Méthode GetById
    public Optional<animal> getAnimalById(Integer id) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal non trouvé avec l'ID: " + id);
        }
        return animalRepository.findById(id);
    }

    // Méthode Delete
    public void deleteAnimal(Integer id) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal non trouvé avec l'ID: " + id);
        }
        animalRepository.deleteById(id);
    }

    public Page<animal> findPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return animalRepository.findAll(pageable);
    }

    public List<AnimalDto> findAll() {
        return animalRepository.findAll().stream()
                .map(AnimalMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<AnimalDto> findAll(Pageable pageable) {
        return animalRepository.findAll(pageable)
                .map(AnimalMapper::toDto);
    }
}