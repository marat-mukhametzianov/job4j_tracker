package ru.job4j.lambda.attachment;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("0123456789", "01234567890123456789");
        Consumer<String> rule = RefMethod::cutOff;
        names.forEach(rule);
    }


    public static void cutOff(String initialString) {
        if(initialString.length() > 10) {
            System.out.println(initialString.substring(0, 10) + "...");
        } else {
            System.out.println(initialString);
        }
    }
}
