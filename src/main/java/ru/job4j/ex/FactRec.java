package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("The parameter is less than a nought.");
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int result = calc(4);
        System.out.println(result);
    }
}
