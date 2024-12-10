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
    private String firstname;
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

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

    public person(Integer age, String firstname, String lastname) {
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
