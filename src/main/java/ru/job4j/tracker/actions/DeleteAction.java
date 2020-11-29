package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.IOutput;

public class DeleteAction implements IUserAction {
    private final IOutput out;

    public DeleteAction(IOutput out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete an item by ID;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        out.println("=== Deleting in progress ====");
        int id = input.requestIntInput("Enter the deleted item's ID:");
        if (tracker.delete(id)) {
            out.println("The element with ID " +id + " has been deleted." + System.lineSeparator());
        } else {
            out.println("Apparently, there is no element with the ID.");
        }
        return true;
    }
}
