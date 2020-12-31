package ru.job4j.tracker.comparators;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemByIdAscTest {

    @Test
    public void compare() {
        List<Item> items = new ArrayList<>();
        for (int i = 3; i > -1; i--) {
            Item item = new Item();
            item.setId(i);
            item.setName("item_" + i);
            items.add(item);
        }
        items.sort(new SortItemByIdAsc());
        assertThat(items.get(1).getId(), is(1));
    }
}