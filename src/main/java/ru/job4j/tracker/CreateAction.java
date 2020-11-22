package ru.job4j.tracker;

public class CreateAction implements IUserAction {
    @Override
    public String name() {
        return "=== Creating a new item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.requestStringInput("Enter a name:");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
