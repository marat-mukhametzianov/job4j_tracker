package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class EditAction implements IUserAction {
    @Override
    public String name() {
        return "Edit an item by ID;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        System.out.println("=== Editing in progress ====");
        int id = input.requestIntInput("Enter the edited item's ID:");
        String name = input.requestStringInput("Enter new item's name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.printf("The element with ID %d has been updated." + System.lineSeparator(), id);
        } else {
            System.out.println("Apparently, there is no element with the ID.");
        }
        return true;
    }
}
