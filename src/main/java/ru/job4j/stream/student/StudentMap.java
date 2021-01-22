package ru.job4j.stream.student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public Map modify(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student,
                        (one, two) -> one
                ));
    }
}
