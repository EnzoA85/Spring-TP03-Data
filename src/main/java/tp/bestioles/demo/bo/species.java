package tp.bestioles.demo.bo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="species")
public class species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "common_name", length = 50, nullable = false)
    private String commonName;
    @Column(name = "latin_name", length = 200, nullable = false)
    private String latinName;

    @OneToMany(mappedBy = "species")
    private Set<animal>animal;
    
    public species() {
    }

    public species(String commonName, String latinName) {
        this.commonName = commonName;
        this.latinName = latinName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    @Override
    public String toString() {
        return "species [id=" + id + ", commonName=" + commonName + ", latinName=" + latinName + "]";
    }

    
}