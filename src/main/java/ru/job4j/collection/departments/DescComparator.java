package ru.job4j.collection.departments;

import java.util.Comparator;

public class DescComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        if (first.split("/")[0].equals(second.split("/")[0])) {
            return first.compareTo(second);
        }else {
            return second.compareTo(first);
        }
    }
}