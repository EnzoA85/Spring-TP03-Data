package tp.bestioles.demo.dal;

import java.util.List;

import tp.bestioles.demo.bo.person;

public interface PersonRepositoryCustom {
    void deleteIfNoAnimal();
    List<person> newPersons(int count);
}
