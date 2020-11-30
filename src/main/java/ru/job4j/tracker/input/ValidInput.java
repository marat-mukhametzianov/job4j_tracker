package ru.job4j.tracker.input;

import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.IOutput;

public class ValidInput extends ConsoleInput {

    public ValidInput(IOutput output) {
        super(output);
    }

    @Override
    public int requestIntInput(String prompt) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.requestIntInput(prompt);
                invalid = false;
            } catch (NumberFormatException numberFormatException) {
                super.getOutput().println("Try to input the valid number.");
            }
        } while (invalid);
        return value;
    }
}
