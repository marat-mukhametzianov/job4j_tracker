package ru.job4j.tracker.actions;

import ru.job4j.tracker.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class CreateAction implements IUserAction {
    @Override
    public String name() {
        return "Create a new item;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        System.out.println("=== Creating a new item ====");
        String name = input.requestStringInput("Enter a name:");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item has been added successfully.");
        return true;
    }
}
