package br.com.bo;

import br.com.dao.imp.PersonDAO;
import br.com.exemplo.Person;

public class PersonBO {

    private PersonDAO personDAO;

    public PersonBO() {

    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person) {
        int idPerson = 0;
        try {
            idPerson = personDAO.addPerson(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idPerson;

    }

    public Person listPerson(int idPerson) {
        Person person = null;
        try {
            person = (Person) personDAO.listPerson(idPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;

    }

    public boolean deletePerson(int idPerson) {
        boolean resultado = false;
        Person person = null;
        try {
            person = (Person) personDAO.listPerson(idPerson);
            resultado = personDAO.deletePerson(person.getIdPersona());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
