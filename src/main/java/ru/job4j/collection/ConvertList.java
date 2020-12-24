package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> initialList) {
        List<Integer> result = new ArrayList<>();
        for (int[] listElement : initialList) {
            for (int arrayElement : listElement) {
                result.add(arrayElement);
            }
        }
        return result;
    }
}
