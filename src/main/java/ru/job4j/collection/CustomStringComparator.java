package ru.job4j.collection;

import java.util.Comparator;

public class CustomStringComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left == null || right == null || left.equals("") || right.equals("")) {
            throw new IllegalArgumentException("Strings can not be null or empty");
        }
        int leftLength = left.length();
        int rightLength = right.length();
        int result = left.charAt(0) - right.charAt(0);
        int loopSize = leftLength < rightLength ? leftLength : rightLength;
        for (int i = 1; i < loopSize; i++) {
            result = left.charAt(i) - right.charAt(i);
            if (result != 0) {
                return result;
            }
        }
        if (result == 0) {
            result = leftLength - rightLength;
        }
        return result;
    }
}
