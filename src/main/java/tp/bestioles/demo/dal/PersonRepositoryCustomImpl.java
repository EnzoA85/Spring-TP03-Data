package tp.bestioles.demo.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import tp.bestioles.demo.bo.person;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void deleteIfNoAnimal() {
        String jpql = "SELECT p FROM person p WHERE p.animalsPerson IS EMPTY";
        TypedQuery<person> query = em.createQuery(jpql, person.class);
        List<person> personSansAnimal = query.getResultList();
        for (person p : personSansAnimal) {
            em.remove(p);
        }
    }

    @Transactional
    public List<person> newPersons(int count) {
        List<person> persons = new ArrayList<>();
        Faker faker = new Faker();
        Random rand = new Random();
    
        for (int i = 0; i < count; i++) {
            person p = new person();
            p.setFirstName(faker.name().firstName());
            p.setLastnNme(faker.name().lastName());
            p.setAge(rand.nextInt(100));
            em.persist(p);
            persons.add(p);
        }
        return persons;
    }
}
