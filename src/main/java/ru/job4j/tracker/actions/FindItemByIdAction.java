package ru.job4j.tracker.actions;

import ru.job4j.tracker.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindItemByIdAction implements IUserAction {
    @Override
    public String name() {
        return "Find an item by ID;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        System.out.println("=== Detected element ====");
        int id = input.requestIntInput("Enter the item's ID:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Apparently, there is no element with the ID.");
        }
        return true;
    }
}
