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
    private String common_name;
    @Column(name = "latin_name", length = 200, nullable = false)
    private String latin_name;

    @OneToMany(mappedBy = "species")
    private Set<animal>animal;
    
    public species() {
    }

    public species(String common_name, String latin_name) {
        this.common_name = common_name;
        this.latin_name = latin_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }
}