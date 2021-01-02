package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void userAsc() {
        User odin = new User("Odin", 10);
        User thor = new User("Thor", 5);
        User loki = new User("Loki", 7);
        List<User> users = new ArrayList<>();
        users.add(odin);
        users.add(thor);
        users.add(loki);
        Collections.sort(users);
        assertThat(users.iterator().next().getName(), is("Loki"));
    }

    @Test
    public void userDesc() {
        User odin = new User("Odin", 10);
        User thor = new User("Thor", 5);
        User loki = new User("Loki", 7);
        List<User> users = new ArrayList<>();
        users.add(odin);
        users.add(thor);
        users.add(loki);
        Collections.sort(users, Collections.reverseOrder());
        assertThat(users.iterator().next().getName(), is("Thor"));
    }
}