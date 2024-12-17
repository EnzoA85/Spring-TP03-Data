package tp.bestioles.demo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.dal.AnimalRepository;

@Service
public class animalService {

    @Autowired
    private AnimalRepository animalRepository;

    // Méthode Create
    public animal createAnimal(animal newAnimal) {
        return animalRepository.save(newAnimal);
    }

    // Méthode Update
    public animal updateAnimal(Integer id, animal updatedAnimal) {
        Optional<animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            animal existingAnimal = optionalAnimal.get();
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setColor(updatedAnimal.getColor());
            existingAnimal.setSex(updatedAnimal.getSex());
            existingAnimal.setSpecies(updatedAnimal.getSpecies());
            return animalRepository.save(existingAnimal);
        }
        throw new RuntimeException("Animal not found with id: " + id);
    }

    // Méthode GetAll
    public List<animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Méthode GetById
    public Optional<animal> getAnimalById(Integer id) {
        return animalRepository.findById(id);
    }

    // Méthode Delete
    public void deleteAnimal(Integer id) {
        animalRepository.deleteById(id);
    }
}