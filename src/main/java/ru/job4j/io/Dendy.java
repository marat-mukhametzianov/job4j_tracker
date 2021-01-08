package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Games:");
            System.out.println("1. Tanks;");
            System.out.println("2. Super Mario;");
            System.out.println("3. Exit.");
            System.out.println("Select the menu item");
            int selected = Integer.valueOf(input.nextLine());
            switch (selected) {
                case 3:
                    System.out.println("Game over!");
                    run = false;
                    break;
                case 2:
                    System.out.println("Super Mario is downloading...");
                    break;
                case 1:
                    System.out.println("Tanks is downloading...");
                    break;
                default:
                    System.out.println("There is no game with that number!");
            }
            System.out.println();
        }
    }
}