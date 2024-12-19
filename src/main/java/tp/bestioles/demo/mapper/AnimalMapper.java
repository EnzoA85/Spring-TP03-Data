package tp.bestioles.demo.mapper;

import tp.bestioles.demo.bo.animal;
import tp.bestioles.demo.dto.AnimalDto;

import java.util.stream.Collectors;

public class AnimalMapper {

    public static AnimalDto toDto(animal animal) {
        String speciesName = animal.getSpecies().getCommonName();
        String persons = animal.getAnimals().stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.joining(", "));

        return new AnimalDto(animal.getId(), animal.getName(), speciesName, animal.getColor(), persons);
    }
}
