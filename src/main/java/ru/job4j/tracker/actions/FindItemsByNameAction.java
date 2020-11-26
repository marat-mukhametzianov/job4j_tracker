package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindItemsByNameAction implements IUserAction {
    @Override
    public String name() {
        return "Find items by name;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        System.out.println("=== Detected items ====");
        String name = input.requestStringInput("Enter the item's name:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (byte i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Apparently, there are no elements with the name.");
        }
        return true;
    }
}
