package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String requestStringInput(String prompt) {
        System.out.println(prompt);
        String result = scanner.nextLine();
        //return scanner.nextLine();
        return result;
    }

    @Override
    public int requestIntInput(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }
}
