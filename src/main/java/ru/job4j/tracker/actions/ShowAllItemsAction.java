package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.IOutput;

import java.util.List;

public class ShowAllItemsAction implements IUserAction {
    private final IOutput out;

    public ShowAllItemsAction(IOutput out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        out.println("=== All available items ====");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("There are not available records.");
        }
        return true;
    }
}
