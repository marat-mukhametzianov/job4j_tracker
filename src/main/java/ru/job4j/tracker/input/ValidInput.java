package ru.job4j.tracker.input;

import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.IOutput;

public class ValidInput implements IInput {
    private final IOutput out;
    private final IInput input;

    public ValidInput(IOutput out, IInput input) {
        this.out = out;
        this.input = input;
    }

    @Override
    public String requestStringInput(String prompt) {
        return input.requestStringInput(prompt);
    }

    @Override
    public int requestIntInput(String prompt) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.requestIntInput(prompt);
                invalid = false;
            } catch (NumberFormatException numberFormatException) {
                out.println("Try to input the valid number.");
            }
        } while (invalid);
        return value;
    }
}
