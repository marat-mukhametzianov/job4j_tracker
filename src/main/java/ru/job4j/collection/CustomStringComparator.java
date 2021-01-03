package ru.job4j.collection;

import java.util.Comparator;

public class CustomStringComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftLength = left.length();
        int rightLength = right.length();
        int result = 0;
        int loopSize = Math.min(leftLength, rightLength);
        for (int i = 0; i < loopSize; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(leftLength, rightLength);
    }
}
