package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        String prompt = "I am the greatest prophet! What would you know?";
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer != 0 && answer != 1) {
            System.out.println("Possibly");
        } else {
            System.out.println(answer == 0 ? "Yes" : "No");
        }
    }
}
