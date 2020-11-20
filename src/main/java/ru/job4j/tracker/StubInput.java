package ru.job4j.tracker;

public class StubInput implements Input {
    public String requestStringInput(String prompt) {
        return null;
    }

    public int requestIntInput(String prompt) {
        return 0;
    }
}
