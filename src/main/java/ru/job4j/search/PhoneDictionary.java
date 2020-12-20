package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> people = new ArrayList<Person>();

    public void add (Person person) {
        this.people.add(person);
    }

    /**
     * Return a list of users containing the key.
     * @param key is a search key.
     * @return is a list of matching users.
     */
    public ArrayList<Person> find (String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person person : people) {
            if (person.getName().contains(key) ||
                person.getSurname().contains(key) ||
                person.getAddress().contains(key) ||
                person.getPhone().contains(key)) {
                result.add(person);
                break;
            }
        }
        return result;
    }
}
