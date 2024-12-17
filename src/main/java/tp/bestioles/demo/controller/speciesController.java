package tp.bestioles.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tp.bestioles.demo.bo.species;
import tp.bestioles.demo.bll.speciesService;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class speciesController {

    @Autowired
    private speciesService speciesService;

    // Create
    @PostMapping("/create")
    public species createSpecies(@RequestBody species newSpecies) {
        return speciesService.createSpecies(newSpecies);
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<species> updateSpecies(@PathVariable Integer id, @RequestBody species updatedSpecies) {
        species species = speciesService.updateSpecies(id, updatedSpecies);
        return ResponseEntity.ok(species);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable Integer id) {
        speciesService.deleteSpecies(id);
        return ResponseEntity.noContent().build();
    }

    // FindAll
    @GetMapping("/all")
    public List<species> getAllSpecies() {
        return speciesService.getAllSpecies();
    }

    // FindById
    @GetMapping("/{id}")
    public ResponseEntity<species> getSpeciesById(@PathVariable Integer id) {
        return speciesService.getSpeciesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
