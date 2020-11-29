package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.IOutput;

public class FindItemByIdAction implements IUserAction {
    private final IOutput out;

    public FindItemByIdAction(IOutput out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find an item by ID;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        out.println("=== Detected element ====");
        int id = input.requestIntInput("Enter the item's ID:");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Apparently, there is no element with the ID.");
        }
        return true;
    }
}
