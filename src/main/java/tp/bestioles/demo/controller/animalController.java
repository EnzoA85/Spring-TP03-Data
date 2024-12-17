package tp.bestioles.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.bll.animalService;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class animalController {

    @Autowired
    private animalService animalService;

    // Create
    @PostMapping("/create")
    public animal createAnimal(@RequestBody animal newAnimal) {
        return animalService.createAnimal(newAnimal);
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<animal> updateAnimal(@PathVariable Integer id, @RequestBody animal updatedAnimal) {
        animal animal = animalService.updateAnimal(id, updatedAnimal);
        return ResponseEntity.ok(animal);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

    // FindAll
    @GetMapping("/all")
    public List<animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // FindById
    @GetMapping("/{id}")
    public ResponseEntity<animal> getAnimalById(@PathVariable Integer id) {
        return animalService.getAnimalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
