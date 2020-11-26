package ru.job4j.tracker.input;

import ru.job4j.tracker.input.IInput;

public class StubInput implements IInput {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String requestStringInput(String prompt) {
        return answers[position++];
    }

    public int requestIntInput(String prompt) {
        return Integer.parseInt(requestStringInput(prompt));
    }
}
