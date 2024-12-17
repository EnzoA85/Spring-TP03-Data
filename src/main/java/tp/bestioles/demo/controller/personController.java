package tp.bestioles.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tp.bestioles.demo.bo.person;
import tp.bestioles.demo.bll.personService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class personController {

    @Autowired
    private personService personService;

    // Create
    @PostMapping("/create")
    public person createPerson(@RequestBody person newPerson) {
        return personService.createPerson(newPerson);
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<person> updatePerson(@PathVariable Integer id, @RequestBody person updatedPerson) {
        person person = personService.updatePerson(id, updatedPerson);
        return ResponseEntity.ok(person);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    // FindAll
    @GetMapping("/all")
    public List<person> getAllPersons() {
        return personService.getAllPersons();
    }

    // FindById
    @GetMapping("/{id}")
    public ResponseEntity<person> getPersonById(@PathVariable Integer id) {
        return personService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paginated")
    public Page<person> getPageable(@PageableDefault(size=10) Pageable pageable){
        return personService.getPageable(pageable);
    }
}
