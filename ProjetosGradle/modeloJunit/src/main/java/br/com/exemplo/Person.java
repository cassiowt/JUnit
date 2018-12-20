package br.com.exemplo;

public class Person {

    private int idPersona;
    private String name;

    public Person() {
    }

    public Person(int idPersona, String name) {
        this.idPersona = idPersona;
        this.name = name;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return "John";
    }

    public String getLastName() {
        return "Doe";
    }


    @Override
    public String toString() {
        return "Person{" +
                "idPersona=" + idPersona +
                ", name='" + name + '\'' +
                '}';
    }
}
