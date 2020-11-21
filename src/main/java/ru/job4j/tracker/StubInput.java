package ru.job4j.tracker;

public class StubInput implements Input {
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
