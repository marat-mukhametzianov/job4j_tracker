package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.IOutput;

public class EditAction implements IUserAction {
    private final IOutput out;

    public EditAction(IOutput out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit an item by ID;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        out.println("=== Editing in progress ====");
        int id = input.requestIntInput("Enter the edited item's ID:");
        String name = input.requestStringInput("Enter new item's name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("The element with ID "
                    + id + " has been updated." + System.lineSeparator());
        } else {
            out.println("Apparently, there is no element with the ID.");
        }
        return true;
    }
}
