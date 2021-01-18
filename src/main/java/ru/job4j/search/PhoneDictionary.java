package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> people = new ArrayList<>();

    public void add(Person person) {
        this.people.add(person);
    }

    /**
     * Return a list of users containing the key.
     * @param key is a search key.
     * @return is a list of matching users.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> rule =
                                person -> {
                                            if (person.getName().contains(key)
                                                ||
                                                person.getSurname().contains(key)
                                                ||
                                                person.getAddress().contains(key)
                                                ||
                                                person.getPhone().contains(key)) {
                                                return true;
                                            }
                                            return false;
        };
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (rule.test(person)){
                result.add(person);
            }
        }
        return result;
    }
}
