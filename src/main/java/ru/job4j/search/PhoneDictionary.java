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
        Predicate<Person> name = person -> person.getName().contains(key);
        Predicate<Person> surname = person -> person.getSurname().contains(key);
        Predicate<Person> address = person -> person.getAddress().contains(key);
        Predicate<Person> phone = person -> person.getPhone().contains(key);
        Predicate<Person> compound = name.or(surname).or(address).or(phone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (compound.test(person)){
                result.add(person);
            }
        }
        return result;
    }
}
