package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.IOutput;
import ru.job4j.tracker.output.StubOutput;

import java.awt.desktop.OpenURIEvent;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private String ns = System.lineSeparator();

    @Test
    public void whenInvalidExit() {
        IOutput output = new StubOutput();
        String[] menuItems = {"10", "0"};
        IInput input = new StubInput(menuItems);
        Tracker tracker = new Tracker();
        IUserAction[] actions = {new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Exit." + ns +
                                            "Wrong selected item. It can be 0 through " + (actions.length - 1) + ns +
                                            "MENU." + ns +
                                            "0. Exit." + ns
                                        ));
    }

    @Test
    public void whenCreateAction() {
        String[] answers = {"0", "item_1", "1"};
        Tracker tracker = new Tracker();
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IUserAction[] actions = {new CreateAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Exit." + ns +
                                            "=== Creating a new item ====" + ns +
                                            "Item has been added successfully." + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Exit." + ns
                                        ));
    }

    @Test
    public void whenExitAction() {
        String[] answerData = {"0"};
        IInput input = new StubInput(answerData);
        Tracker tracker = new Tracker();
        IOutput out = new StubOutput();
        IUserAction[] actions = {new ExitAction()};
        new StartUI(out).init(input, tracker,actions);
        assertThat(out.toString(), is("MENU." + ns + "0. Exit." + ns));
    }

    @Test
    public void whenShowAllItemsActionOneItem() {
        String[] answers = {"0", "item_1", "1", "2"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IUserAction[] actions = {new CreateAction(output), new ShowAllItemsAction(output), new ExitAction()};
        Tracker tracker = new Tracker();
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Show all items;" + ns +
                                            "2. Exit." + ns +
                                            "=== Creating a new item ====" + ns +
                                            "Item has been added successfully." + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Show all items;" + ns +
                                            "2. Exit." + ns +
                                            "=== All available items ====" + ns +
                                            "Item {" + ns +
                                                    "\tid = 1" + ns +
                                                    "\tname = \"item_1\"" + ns +
                                                    "}" + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Show all items;" + ns +
                                            "2. Exit." + ns
                                        ));
    }

    @Test
    public void whenShowAllItemsActionNoItem() {
        String[] answers = {"0", "1"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IUserAction[] actions = {new ShowAllItemsAction(output), new ExitAction()};
        Tracker tracker = new Tracker();
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Show all items;" + ns +
                                            "1. Exit." + ns +
                                            "=== All available items ====" + ns +
                                            "There are not available records." + ns +
                                            "MENU." + ns +
                                            "0. Show all items;" + ns +
                                            "1. Exit." + ns
                                        ));
    }

    @Test
    public void whenFindItemsByNameAction() {
        String[] answers = {"0", "item_1", "0", "item_1", "1", "item_1", "2"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        Tracker tracker = new Tracker();
        IUserAction[] actions = {new CreateAction(output), new FindItemsByNameAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker,actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find items by name;" + ns +
                                            "2. Exit." + ns +
                                            "=== Creating a new item ====" + ns +
                                            "Item has been added successfully." + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find items by name;" + ns +
                                            "2. Exit." + ns +
                                            "=== Creating a new item ====" + ns +
                                            "Item has been added successfully." + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find items by name;" + ns +
                                            "2. Exit." + ns +
                                            "=== Detected items ====" + ns +
                                            "Item {" + ns +
                                            "\tid = 1" + ns +
                                            "\tname = \"item_1\"" + ns +
                                            "}" + ns +
                                            "Item {" + ns +
                                            "\tid = 2" + ns +
                                            "\tname = \"item_1\"" + ns +
                                            "}" + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find items by name;" + ns +
                                            "2. Exit." + ns
                                        ));
    }

    @Test
    public void whenFindItemsByNameActionNoName() {
        String[] answers = {"0", "item_1", "1"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IUserAction[] actions = {new FindItemsByNameAction(output), new ExitAction()};
        Tracker tracker = new Tracker();
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Find items by name;" + ns +
                                            "1. Exit." + ns +
                                            "=== Detected items ====" + ns +
                                            "Apparently, there are no elements with the name." + ns +
                                            "MENU." + ns +
                                            "0. Find items by name;" + ns +
                                            "1. Exit." + ns
                                        ));
    }

    @Test
    public void whenFindByIdAction() {
        String[] answers = {"0", "item_1", "1", "1", "2"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IUserAction[] actions = {new CreateAction(output), new FindItemByIdAction(output), new ExitAction()};
        Tracker tracker = new Tracker();
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find an item by ID;" + ns +
                                            "2. Exit." + ns +
                                            "=== Creating a new item ====" + ns +
                                            "Item has been added successfully." + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find an item by ID;" + ns +
                                            "2. Exit." + ns +
                                            "=== Detected element ====" + ns +
                                            "Item {" + ns +
                                            "\tid = 1" + ns +
                                            "\tname = \"item_1\"" + ns +
                                            "}" + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find an item by ID;" + ns +
                                            "2. Exit." + ns
                                        ));
    }

    @Test
    public void whenFindByIdActionNoSuchId() {
        String[] answers = {"0", "item_1", "1", "0", "2"};
        IInput input = new StubInput(answers);
        IOutput output = new StubOutput();
        IUserAction[] actions = {new CreateAction(output), new FindItemByIdAction(output), new ExitAction()};
        Tracker tracker = new Tracker();
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(   "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find an item by ID;" + ns +
                                            "2. Exit." + ns +
                                            "=== Creating a new item ====" + ns +
                                            "Item has been added successfully." + ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find an item by ID;" + ns +
                                            "2. Exit." + ns +
                                            "=== Detected element ====" + ns +
                                            "Apparently, there is no element with the ID."+ ns +
                                            "MENU." + ns +
                                            "0. Create a new item;" + ns +
                                            "1. Find an item by ID;" + ns +
                                            "2. Exit." + ns
                                        ));
    }
}