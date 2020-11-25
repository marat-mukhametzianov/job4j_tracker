package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.actions.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        String[] askedData = {"0", "item_1", "1"};
        IInput stubInput = new StubInput(askedData);
        IUserAction[] actions = {new CreateAction(), new ExitAction()};
        Tracker tracker = new Tracker();
        new StartUI().init(stubInput, tracker,actions);
        assertThat(tracker.findAll()[0].getName(), is("item_1"));
    }

    @Test
    public void replaceItemId1() {
        String[] askedData = {"0", "item_1", "1", "1", "item_item", "2"};
        IInput stubInput = new StubInput(askedData);
        Tracker tracker = new Tracker();
        IUserAction[] actions = {new CreateAction(), new EditAction(), new ExitAction()};
        new StartUI().init(stubInput, tracker,actions);
        assertThat(tracker.findAll()[0].getName(), is("item_item"));
    }

    @Test
    public void whenDeleteOnlyItem() {
        String[] stubData = {"0", "item_1", "1", "1", "2"};
        IInput stubInput = new StubInput(stubData);
        IUserAction[] actions = {new CreateAction(), new DeleteAction(), new ExitAction()};
        Tracker tracker = new Tracker();
        new StartUI().init(stubInput, tracker, actions);
        assertThat(tracker.findAll().length, is(0));
    }
}