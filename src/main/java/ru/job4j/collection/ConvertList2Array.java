package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {


    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] result = toArray(list, 3);
        for (int[] row : result) {
            for (int cell : row) {
                System.out.println(cell + " ");
            }
            System.out.println();
        }
    }

    public static int[][] toArray(List<Integer> list, int numberOfCells) {
        int groups = (int) Math.ceil((double) list.size() / numberOfCells);
        int[][] result = new int[groups][numberOfCells];
        int row = 0;
        int cell = 0;
        for (int item : list) {
            result[row][cell] = item;
            cell++;
            if (cell == 3) {
                cell = 0;
                row++;
            }
        }
        return result;
    }
}
