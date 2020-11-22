package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAdd() {
        String[] answers = {"item_1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.add(tracker, input);
        Item[] createdItemArray = tracker.findAll();
        Item expectedItem = new Item("item_1");
        for (int i = 0; i < 3; i++) {
            assertThat(createdItemArray[0].getName(), is(expectedItem.getName()));
        }
    }

    @Test
    public void whenDeleteOnlyItem() {
        Item item = new Item();
        item.setName("new item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId())};
        Input input = new StubInput(answer);
        StartUI.deleteItem(tracker, input);
        Assert.assertEquals(null, tracker.findById(item.getId()));
    }
}