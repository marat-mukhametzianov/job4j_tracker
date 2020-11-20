package ru.job4j.tracker;

public class StubInput implements Input {
    public String askStr(String question) {
        return null;
    }

    public int askInt(String question) {
        return 0;
    }
}
