package org.example;

import org.example.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonsDB {
    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public String getPersonName(int i) {
        return persons.get(i).getName();
    }
}
