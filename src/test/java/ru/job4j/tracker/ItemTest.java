package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareTo() {
        Item one = new Item("one");
        one.setId(1);
        Item two = new Item("two");
        two.setId(1);
        Item three = new Item("three");
        three.setId(2);
        Set<Item> items = new TreeSet<>();
        items.add(one);
        items.add(two);
        items.add(three);
        Iterator iterator = items.iterator();
        assertThat(iterator.next(), is(one));
    }
}