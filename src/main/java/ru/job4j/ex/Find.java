package ru.job4j.ex;

public class Find {
    public static String get(String[] data, int index) {
        if (index >= data.length || index < 0) {
            throw new IllegalArgumentException("The index is out of bounds");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data = {"onw", "two", "three"};
        String rsl = Find.get(data, 3);
        System.out.println(rsl);
    }
}
