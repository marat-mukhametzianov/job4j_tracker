package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                7,
                46,
                -158,
                17,
                3,
                27,
                11,
                -5,
                18
        );
        List<Integer> result = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
