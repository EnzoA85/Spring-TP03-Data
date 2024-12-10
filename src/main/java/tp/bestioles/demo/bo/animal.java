package tp.bestioles.demo.bo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="animal")
public class animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "color", length = 50, nullable = false)
    private String color;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "sex", length = 255, nullable = false)
    private String sex;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "species_id")
    private species species;

    @ManyToMany(mappedBy = "animalsPerson")
    Set<person> animals;

    {
        animals=new HashSet<>();
    }
    
    public animal() {
    }

    public animal(String color, String name, String sex, species species) {
        this.color = color;
        this.name = name;
        this.sex = sex;
        this.species = species;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public species getSpecies() {
        return species;
    }

    public void setSpecies(species species) {
        this.species = species;
    }
}
