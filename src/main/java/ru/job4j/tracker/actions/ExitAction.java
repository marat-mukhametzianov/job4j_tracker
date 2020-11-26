package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.Tracker;

public class ExitAction implements IUserAction {
    @Override
    public String name() {
        return "Exit.";
    }

    @Override
    public boolean execute(IInput input, Tracker tracker) {
        return false;
    }
}
