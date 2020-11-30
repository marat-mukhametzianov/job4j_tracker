package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) throws Exception {
        if (n < 0) {
            throw new Exception("The parameter is less than a nought.");
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int result = 0;
        try {
            result = calc(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
