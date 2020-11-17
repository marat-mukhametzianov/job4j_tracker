package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        byte matchQuantity = 11;
        System.out.printf("There are %d matches on the table.\n", matchQuantity);
        while (running) {
            /**
             * Цикл, который крутится до тех пор, пока первый игрок не возмет правильное количество спичек
             */
            byte picked;
            boolean takingIsCorrect;
            do {
                System.out.printf("How many matches pick the first player up?\n");
                picked = Byte.valueOf(input.nextLine());
                takingIsCorrect = picked > 3 || picked < 1;
                if (takingIsCorrect) {
                    System.out.println("Wrong quantity! Try again!");
                }
            } while (takingIsCorrect);
            matchQuantity = (byte) (matchQuantity - picked) < 0 ? 0 : (byte) (matchQuantity - picked);
            System.out.printf("There are %d matches on the table.\n", matchQuantity);
            if (matchQuantity == 0) {
                running = false;
                System.out.printf("The player 1 have won!");
            }else {
                do{
                    System.out.printf("How many matches pick the second player up?\n");
                    picked = Byte.valueOf(input.nextLine());
                    takingIsCorrect = picked > 3 || picked < 1;
                    if (takingIsCorrect) {
                        System.out.println("Wrong quantity! Try again!");
                    }
                } while (takingIsCorrect);
                matchQuantity = (byte) (matchQuantity - picked) < 0 ? 0 : (byte) (matchQuantity - picked);
                System.out.printf("There are %d matches on the table.\n", matchQuantity);
                if (matchQuantity == 0) {
                    running = false;
                    System.out.printf("The player 2 have won!");
                }
            }
        }
    }
}
