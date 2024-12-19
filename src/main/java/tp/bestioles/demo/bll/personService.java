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
import tp.bestioles.demo.bo.person;
import tp.bestioles.demo.dal.PersonRepository;
import tp.bestioles.demo.dto.PersonDto;
import tp.bestioles.demo.exception.EntityToCreateHasAnIdException;
import tp.bestioles.demo.exception.EntityToUpdateHasNoIdException;
import tp.bestioles.demo.mapper.PersonMapper;

@Service
public class personService {

    @Autowired
    private PersonRepository personRepository;

    // Méthode Create
    public person createPerson(person newPerson) {
        if (newPerson.getId() != null) {
            throw new EntityToCreateHasAnIdException("L'entité à créer ne doit pas avoir un ID.");
        }
        return personRepository.save(newPerson);
    }

    // Méthode Update
    public person updatePerson(Integer id, person updatedPerson) {
        if (updatedPerson.getId() == null) {
            throw new EntityToUpdateHasNoIdException("L'entité à mettre à jour doit avoir un ID.");
        }
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Personne non trouvé avec l'ID: " + id);
        }
        person existingPerson = personRepository.findById(id).orElseThrow();
        existingPerson.setAge(updatedPerson.getAge());
        existingPerson.setFirstName(updatedPerson.getFirstName());
        existingPerson.setLastnNme(updatedPerson.getLastName());
        return personRepository.save(existingPerson);
    }

    // Méthode GetAll
    public List<person> getAllPersons() {
        return personRepository.findAll();
    }

    // Méthode GetById
    public Optional<person> getPersonById(Integer id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Personne non trouvé avec l'ID: " + id);
        }
        return personRepository.findById(id);
    }

    // Méthode Delete
    public void deletePerson(Integer id) {
        if (!personRepository.existsById(id)) {
            throw new EntityNotFoundException("Personne non trouvé avec l'ID: " + id);
        }
        personRepository.deleteById(id);
    }

    // Méthode Pageable
    public Page<person> getPageable(Pageable pageable){
        return personRepository.findAll(pageable);
    }

    public Page<person> findPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return personRepository.findAll(pageable);
    }

    public List<PersonDto> findAll() {
        return personRepository.findAll().stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<PersonDto> findAll(Pageable pageable) {
        return personRepository.findAll(pageable)
                .map(PersonMapper::toDto);
    }
}