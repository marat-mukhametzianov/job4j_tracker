package ru.job4j.ex;

import java.util.Scanner;

public class Fract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a factorial number:");
        int factorialNumber = scanner.nextInt();
        int result = calc(factorialNumber);
        System.out.printf("Factorial %d = %d", factorialNumber, result);
    }

    public static int calc(int n) {
        int result = 1;
        if(n < 0) {
            throw new IllegalArgumentException("n less than 0. Should use a positive number.");
        }
        if(n > 0) {
            for(int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        return result;
    }
}
