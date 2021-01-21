package ru.job4j.stream;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {10, 20}
        };
        int[] modifiedMatrix = Arrays.stream(matrix)
                .flatMapToInt(single -> Arrays.stream(single))
                .toArray();
        System.out.println(Arrays.toString(modifiedMatrix));
    }
}
