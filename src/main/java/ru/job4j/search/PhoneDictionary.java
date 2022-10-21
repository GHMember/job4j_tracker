package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            ArrayList<String> personData = new ArrayList<>(
                    Arrays.asList(pers.getName(), pers.getSurname(), pers.getPhone(), pers.getAddress())
            );
            if (personData.contains(key)) {
                result.add(pers);
            }
        }
        return result;
    }
}
