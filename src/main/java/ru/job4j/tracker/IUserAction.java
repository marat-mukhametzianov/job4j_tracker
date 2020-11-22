package ru.job4j.tracker;

public interface IUserAction {
    String name();
    boolean execute(Input input, Tracker tracker);
}
