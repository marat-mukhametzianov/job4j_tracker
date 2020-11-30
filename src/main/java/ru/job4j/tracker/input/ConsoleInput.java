package ru.job4j.tracker.input;

import ru.job4j.tracker.input.IInput;
import ru.job4j.tracker.output.IOutput;

import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scanner = new Scanner(System.in);
    private IOutput output;

    public IOutput getOutput() {
        return output;
    }
    public ConsoleInput() {
    }

    public ConsoleInput(IOutput output) {
        this.output = output;
    }

    @Override
    public String requestStringInput(String prompt) {
        output.println(prompt);
        String result = scanner.nextLine();
        return result;
    }

    @Override
    public int requestIntInput(String prompt) {
        output.println(prompt);
        int iii = Integer.parseInt(scanner.nextLine());
        return iii;
        ///return Integer.parseInt(scanner.nextLine());
    }
}
