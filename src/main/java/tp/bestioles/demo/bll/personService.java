package tp.bestioles.demo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tp.bestioles.demo.bo.person;
import tp.bestioles.demo.dal.PersonRepository;

@Service
public class personService {

    @Autowired
    private PersonRepository personRepository;

    // Méthode Create
    public person createPerson(person newPerson) {
        return personRepository.save(newPerson);
    }

    // Méthode Update
    public person updatePerson(Integer id, person updatedPerson) {
        Optional<person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            person existingPerson = optionalPerson.get();
            existingPerson.setAge(updatedPerson.getAge());
            existingPerson.setFirstName(updatedPerson.getFirstName());
            existingPerson.setLastnNme(updatedPerson.getLastName());
            return personRepository.save(existingPerson);
        }
        throw new RuntimeException("Person not found with id: " + id);
    }

    // Méthode GetAll
    public List<person> getAllPersons() {
        return personRepository.findAll();
    }

    // Méthode GetById
    public Optional<person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    // Méthode Delete
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    // Méthode Pageable
    public Page<person> getPageable(Pageable pageable){
        return personRepository.findAll(pageable);
    }
}