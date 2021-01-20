package ru.job4j.stream.student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(
            List<Student> students,
            Predicate<Student> compoundRule
    ) {
        return students.stream()
                                .filter(compoundRule)
                                .collect(Collectors.toList());
    }
}
