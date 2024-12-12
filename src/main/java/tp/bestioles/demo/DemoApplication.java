package tp.bestioles.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.bo.person;
import tp.bestioles.demo.bo.species;
import tp.bestioles.demo.dal.AnimalRepository;
import tp.bestioles.demo.dal.PersonRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private AnimalRepository animalRepository;
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	public DemoApplication(PersonRepository personRepository, AnimalRepository animalRepository) {
		this.personRepository = personRepository;
		this.animalRepository = animalRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		//TP 3
		person person = new person(20, "Enzo", "Archambaud");
		personRepository.save(person);

		species species = new species("Ours","Ursidae");

		animal animal = new animal("Jaune","Winnie","M",species);
		person.animalsPerson.add(animal);
		animalRepository.save(animal);

		System.out.println(personRepository.findAll());

		System.out.println(animalRepository.findById(1));

		person person2 = new person(99, "Personne", "Asupprimer");
		personRepository.save(person2);
		personRepository.delete(person2);

	}
}
