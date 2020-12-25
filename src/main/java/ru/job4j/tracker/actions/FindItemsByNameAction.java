package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.IOutput;

import java.util.List;

public class FindItemsByNameAction implements IUserAction {
    private final IOutput out;

    public FindItemsByNameAction(IOutput out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        out.println("=== Detected items ====");
        String name = input.requestStringInput("Enter the item's name:");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Apparently, there are no elements with the name.");
        }
        return true;
    }
}
