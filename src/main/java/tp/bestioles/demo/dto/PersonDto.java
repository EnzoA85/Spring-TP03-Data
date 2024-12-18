package tp.bestioles.demo.dto;

public class PersonDto {
    private Integer id;
    private String name;
    private Integer age;
    private String[] animals;

    public PersonDto(Integer id, String name, Integer age, String[] animals) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.animals = animals;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getAnimals() {
        return animals;
    }

    public void setAnimals(String[] animals) {
        this.animals = animals;
    }
}
