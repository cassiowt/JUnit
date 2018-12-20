package br.com.exemplo;

import br.com.bo.PersonBO;
import br.com.dao.imp.PersonDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
@MockitoSettings (strictness = Strictness.STRICT_STUBS)
class MockitoDemo {

    private Person person;
    private ArrayList<Person> persons;
    private PersonBO personBO;

    @Mock
    private PersonDAO personDAOMock;

    @BeforeEach
    public void upSet(){
       person = new Person(1, "Renato");
       persons = new ArrayList<>(
               Arrays.asList(new Person(2, "Pedro"),
                             new Person(3, "Paulo"),
                             new Person(4, "Pereira")
               ));
       personBO = new PersonBO();
       personBO.setPersonDAO(personDAOMock);

    }

    @Test
    public void testAddPerson() {
        when(personDAOMock.addPerson(person)).thenReturn(1);
        assertTrue(personBO.addPerson(person) == 1);
    }

    @Test
    public void testListPerson() {
        when(personDAOMock.listPerson(1)).thenReturn(person);
        assertTrue(personBO.listPerson(1).getName().equals("Renato"));
    }

    @Test
    public void testDeletePerson() {
        when(personDAOMock.listPerson(1)).thenReturn(person);
        when(personDAOMock.deletePerson(1)).thenReturn(true);
        assertTrue(personBO.deletePerson(1) == true);
    }    @Test


    public void testListAllPerson() {
        when(personDAOMock.listAllPerson()).thenReturn(persons);
        assertEquals(personBO.listAllPerson().get(1).getName(),"Paulo");
    }



}
