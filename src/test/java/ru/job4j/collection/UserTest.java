package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void TreeAutomaticAsc() {
        User odin = new User("Odin", 10);
        User thor = new User("Thor", 5);
        User loki = new User("Loki", 7);
        Set<User> users = new TreeSet<>();
        users.add(odin);
        users.add(thor);
        users.add(loki);
        Iterator<User> iterator = users.iterator();
        assertThat(iterator.next(), is(loki));
    }

    @Test
    public void ArrayListAsc() {
        User odin = new User("Loki", 10);
        User thor = new User("Thor", 5);
        User loki = new User("Odin", 7);
        List<User> users = Arrays.asList(odin, thor, loki);
        users.sort(new DescUser());

    }
}