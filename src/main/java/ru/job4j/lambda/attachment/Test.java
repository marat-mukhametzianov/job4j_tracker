package ru.job4j.lambda.attachment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("One");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("Lambda starts");
            return left.compareTo(right);
        };

        names.sort(comparator);
        names = Arrays.asList("One", "Two");
        names.sort(comparator);
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        Function<String, Integer> instanceOfAnonymusClassImplementingInterface = new Function<String, Integer>() {
            @Override
            public Integer apply(String inletData) {
                return Integer.parseInt(inletData);
            }
        };
        System.out.println(instanceOfAnonymusClassImplementingInterface.apply("10") + 20);
    }
}
