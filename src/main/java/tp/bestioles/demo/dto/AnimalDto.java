package tp.bestioles.demo.dto;

public class AnimalDto {
    private Integer id;
    private String name;
    private String species;
    private String color;
    private String persons;

    public AnimalDto(Integer id, String name, String species, String color, String persons) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.color = color;
        this.persons = persons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }
}
