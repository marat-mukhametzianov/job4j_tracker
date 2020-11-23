package ru.job4j.tracker.actions;

import ru.job4j.tracker.IInput;
import ru.job4j.tracker.Tracker;

public interface IUserAction {
    String name();
    boolean execute(IInput input, Tracker tracker);
}
