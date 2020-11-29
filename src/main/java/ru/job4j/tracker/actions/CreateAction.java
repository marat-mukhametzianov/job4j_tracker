package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.IOutput;

public class CreateAction implements IUserAction {
    private final IOutput out;

    public CreateAction(IOutput out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new item;";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        out.println("=== Creating a new item ====");
        String name = input.requestStringInput("Enter a name:");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Item has been added successfully.");
        return true;
    }
}
