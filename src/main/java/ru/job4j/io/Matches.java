package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        boolean running = true;
        byte matchesRemain = 11;
        System.out.printf("There are %d matches on the table.\n", matchesRemain);
        while (running) {
            byte picked = getPicked("How many matches pick the first player up?\n");
            matchesRemain = matchesRemain(matchesRemain, picked);

            if (matchesRemain == 0) {
                running = false;
                running = checkWin(matchesRemain, running, "first");
            }else {
                picked = getPicked("How many matches pick the second player up?\n");
                matchesRemain = matchesRemain(matchesRemain, picked);
                running = checkWin(matchesRemain, running, "second");
            }
        }
    }

    private static boolean checkWin(byte matchesRemain, boolean running, String whoWon) {
        if (matchesRemain == 0) {
            running = false;
            System.out.printf("The player %s have won!", whoWon);
        }
        return running;
    }

    private static byte matchesRemain(byte matchesRemain, byte picked) {
        matchesRemain = (byte) (matchesRemain - picked) < 0 ? 0 : (byte) (matchesRemain - picked);
        System.out.printf("There are %d matches on the table.\n", matchesRemain);
        return matchesRemain;
    }

    private static byte getPicked(String prompt) {
        byte picked;
        boolean takingIsCorrect;
        Scanner input = new Scanner(System.in);
        do {
            System.out.printf(prompt);
            picked = Byte.valueOf(input.nextLine());
            takingIsCorrect = picked > 3 || picked < 1;
            if (takingIsCorrect) {
                System.out.println("Wrong quantity! Try again!");
            }
        } while (takingIsCorrect);
        return picked;
    }
}
