package ru.job4j.tracker.actions;

import ru.job4j.tracker.IInput;
import ru.job4j.tracker.Tracker;

public class DeleteAction implements IUserAction {
    @Override
    public String name() {
        return "Delete an item by ID;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        System.out.println("=== Deleting in progress ====");
        int id = input.requestIntInput("Enter the deleted item's ID:");
        if (tracker.delete(id)) {
            System.out.printf("The element with ID %d has been deleted." + System.lineSeparator(), id);
        } else {
            System.out.println("Apparently, there is no element with the ID.");
        }
        return true;
    }
}
