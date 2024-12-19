package tp.bestioles.demo.mapper;

import tp.bestioles.demo.bo.person;
import tp.bestioles.demo.dto.PersonDto;

public class PersonMapper {

    public static PersonDto toDto(person person) {
        String fullName = person.getLastName().toUpperCase() + " " + person.getFirstName();
        String[] animals = person.getAnimalsPerson().stream()
                .map(animal -> animal.getName() + " (" + animal.getSpecies().getCommonName() + ")")
                .toArray(String[]::new);

        return new PersonDto(person.getId(), fullName, person.getAge(), animals);
    }
}
