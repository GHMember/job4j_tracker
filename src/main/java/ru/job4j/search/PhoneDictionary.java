package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if (pers.getName().equals(key) || pers.getSurname().equals(key) || pers.getPhone().equals(key)
                    || pers.getAddress().equals(key)) {
                result.add(pers);
            }
        }
        return result;
    }
}
