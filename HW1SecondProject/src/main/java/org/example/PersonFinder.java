package org.example;

public class PersonFinder {
    PersonsDB personsDB = new PersonsDB();

    public PersonFinder() {
        Person person1 = new Person("Kolya" , 23);
        Person person2 = new Person("Nikita" , 24);
        Person person3 = new Person("Stepan" , 30);
        Person person4 = new Person("Alex" , 18);
        personsDB.addPerson(person1);
        personsDB.addPerson(person2);
        personsDB.addPerson(person3);
        personsDB.addPerson(person4);
    }

    public void findPersonByName(String name) {
        for(int i = 0; i < personsDB.getPersons().size(); i++) {
            if(personsDB.getPersonName(i) == name) {
                System.out.println("Person " + name + " have been found!");
                break;
            }
        }
    }
}
