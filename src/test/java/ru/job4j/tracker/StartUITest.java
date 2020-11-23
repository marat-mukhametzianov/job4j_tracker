package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.actions.CreateAction;
import ru.job4j.tracker.actions.DeleteAction;
import ru.job4j.tracker.actions.EditAction;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAdd() {
        String[] answers = {"item_1"};
        IInput input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction().execute(input,tracker);
        Item[] allItems = tracker.findAll();
        assertThat(allItems[0].getName(), is("item_1"));
    }

    @Test
    public void whenDeleteOnlyItem() {
        Item item = new Item();
        item.setName("item_1");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId())};
        IInput input = new StubInput(answer);
        new DeleteAction().execute(input, tracker);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void replaceItemId1() {
        Item item = new Item("item_1");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "item_item"};
        IInput input = new StubInput(answers);
        new EditAction().execute(input, tracker);
        assertThat(tracker.findById(Integer.parseInt(answers[0])).getName(), is("item_item"));
    }
}