package br.com.dao.imp;

import br.com.exemplo.Person;
import java.util.ArrayList;

public interface PersonDAO<Person> {

    public int addPerson(Person person);
    public Person listPerson(int idPerson);
    public ArrayList<Person> listAllPerson();
    public boolean deletePerson(int idPerson);

}
