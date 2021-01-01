package ru.job4j.collection;

import ru.job4j.collection.User;

import java.util.Comparator;

public class DescUser implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int result = 0;
        String one = o1.getName();
        String two = o2.getName();
        if (one.equals(two)) {
            if (o1.getAge() < o2.getAge()) {
                result = 1;
            }
            if (o1.getAge() > o2.getAge()) {
                result = -1;
            }
        } else if (one.compareTo(two) < 0) {
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }
}
