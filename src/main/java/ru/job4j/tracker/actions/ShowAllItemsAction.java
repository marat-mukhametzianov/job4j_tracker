package ru.job4j.tracker.actions;

import ru.job4j.tracker.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ShowAllItemsAction implements IUserAction {
    @Override
    public String name() {
        return "Show all items;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        System.out.println("=== All available items ====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are not available records." + System.lineSeparator());
        }
        return true;
    }
}
