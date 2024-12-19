package tp.bestioles.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.bo.person;
import tp.bestioles.demo.bo.species;
import tp.bestioles.demo.dal.AnimalRepository;
import tp.bestioles.demo.dal.PersonRepository;
import tp.bestioles.demo.dal.PersonRepositoryCustom;
import tp.bestioles.demo.dal.SpeciesRepository;

@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner{

	private AnimalRepository animalRepository;
	private PersonRepository personRepository;
	private SpeciesRepository speciesRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	public DemoApplication(PersonRepository personRepository, AnimalRepository animalRepository, SpeciesRepository speciesRepository) {
		this.personRepository = personRepository;
		this.animalRepository = animalRepository;
		this.speciesRepository = speciesRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		//TP 3
		// person person = new person(20, "Enzo", "Archambaud");
		// personRepository.save(person);

		// species species = new species("Ours","Ursidae");

		// animal animal = new animal("Jaune","Winnie","M",species);
		// person.animalsPerson.add(animal);
		// animalRepository.save(animal);

		// System.out.println(personRepository.findAll());

		// System.out.println(animalRepository.findById(1));

		// person person2 = new person(99, "Personne", "Asupprimer");
		// personRepository.save(person2);
		// personRepository.delete(person2);

		//TP 4
		// System.out.println(speciesRepository.findFirstByCommonName("Chat"));
		// System.out.println(speciesRepository.findByLatinNameContainingIgnoreCase("Canis"));

		// System.out.println(personRepository.findByLastNameOrFirstName("Lamarque", "Jean"));
		// System.out.println(personRepository.findByLastNameOrFirstName("Loizeau", "Jean"));
		// System.out.println(personRepository.findByAgeGreaterThanEqual(54));

		// System.out.println(animalRepository.findBySpecies(speciesRepository.findById(1).get()));
		// List<String> colorsToSearch = Arrays.asList("Blanc", "Jaune", "Noir","Roux");
		// System.out.println(animalRepository.findByColorIn(colorsToSearch));

		//TP 5
		// System.out.println(speciesRepository.findAllByCommonNameAscendingSql());
		// System.out.println(speciesRepository.findByCommonNameLike("Ch"));

		// System.out.println(personRepository.findByAgeBetween(30, 70));
		// System.out.println(personRepository.findAllPersonPossedeAnimalDonne("Médor"));

		// System.out.println(animalRepository.findBySex("M"));
		// System.out.println(animalRepository.findDoesAnimalBelongToAnyPerson("Médor"));
		// System.out.println(animalRepository.findDoesAnimalBelongToAnyPerson("Winnie"));

		//TP 6
		//this.personRepository.deleteIfNoAnimal();
		//this.personRepository.newPersons(5);

		//TP 7
		//Quelle méthode du repository utiliser ?
		//La méthode à utiliser dans le repository est findAll(Pageable pageable)
		
		//Comment écrire la requête Postman pour demander la page numéro 2 et de taille 2 ?
		//La requête Postman pour demander la page numéro 2 avec une taille de 2 est : http://localhost:8080/api/persons/paginated?page=1&size=2.
	
		//TP 8
		//http://localhost:8080/api/animal/findPage?pageNumber=0&pageSize=2
		//http://localhost:8080/api/person/findPage?pageNumber=0&pageSize=2
		//http://localhost:8080/api/species/findPage?pageNumber=0&pageSize=2

	}
}

