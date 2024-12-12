package tp.bestioles.demo.bo;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="person")
public class person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "firstname", length = 50, nullable = false)
    private String firstName;
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(
        name="person_animals",
        joinColumns = @JoinColumn(name="person_id"),
        inverseJoinColumns = @JoinColumn(name="animals_id")
    )
    public Set<animal>animalsPerson;

    {
        animalsPerson=new HashSet<>();
    }
    
    public person() {
    }

    public person(Integer age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastnNme(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "person [id=" + id + ", age=" + age + ", firstname=" + firstName + ", lastname=" + lastName + "]";
    }
}
