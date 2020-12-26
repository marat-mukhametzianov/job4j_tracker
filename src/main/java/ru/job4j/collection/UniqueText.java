package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originalText, String comparedText) {
        boolean result = true;
        String[] text = originalText.split(" ");
        String[] checked = comparedText.split(" ");
        HashSet<String> textSet = new HashSet<>(Arrays.asList(text));
        for (String element : checked) {
            if (!textSet.contains(element)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
