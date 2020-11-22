package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddThreeItems() {
        String[] answers = {"item_1", "item_2", "item_3"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.add(tracker, input);
        StartUI.add(tracker, input);
        StartUI.add(tracker, input);
        Item[] createdItemArray = tracker.findAll();
        Item[] expectedItemArray = new Item[3];
        for (int i = 0; i < 3; i++) {
            Item item = new Item("item_" + (i + 1));
            item.setId(i + 1);
            expectedItemArray[i] = item;
        }
        for (int i = 0; i < 3; i++) {
            assertThat(createdItemArray[i].getName(), is(expectedItemArray[i].getName()));
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