package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        boolean running = true;
        byte matchesRemain = 11;
        System.out.printf("There are %d matches on the table.\n", matchesRemain);
        while (running) {
            /**
             * First player's turn
             */
            byte picked = getPicked("first");
            matchesRemain = matchesRemain(matchesRemain, picked);
            running = checkWin(matchesRemain, running, "first");
            /**
             * If the game has to carry on then second player's turn
             */
            if (running) {
                picked = getPicked("second");
                matchesRemain = matchesRemain(matchesRemain, picked);
                running = checkWin(matchesRemain, running, "second");
            }
        }
    }

    private static boolean checkWin(byte matchesRemain, boolean running, String whoWon) {
        if (matchesRemain == 0) {
            running = false;
            System.out.printf("The player %s has won!", whoWon);
        }
        return running;
    }

    private static byte matchesRemain(byte matchesRemain, byte picked) {
        matchesRemain = (byte) (matchesRemain - picked) < 0 ? 0 : (byte) (matchesRemain - picked);
        System.out.printf("There are %d matches on the table.\n", matchesRemain);
        return matchesRemain;
    }

    private static byte getPicked(String player) {
        byte picked;
        boolean takingIsCorrect;
        Scanner input = new Scanner(System.in);
        do {
            System.out.printf("How many matches picked the %s player up?\n", player);
            picked = Byte.valueOf(input.nextLine());
            takingIsCorrect = picked > 3 || picked < 1;
            if (takingIsCorrect) {
                System.out.println("Wrong quantity! Try again!");
            }
        } while (takingIsCorrect);
        return picked;
    }
}
