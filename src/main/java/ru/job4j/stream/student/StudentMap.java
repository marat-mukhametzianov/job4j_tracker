package ru.job4j.stream.student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(10, "Smith"),
                new Student(20, "Fox"),
                new Student(30, "Tocci")
        );
        Map studentMap = students.stream()
                .collect(Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student
                ));
        studentMap.forEach((k, v) ->
                System.out.println("The key " + k + ", the value " + v));
    }
}
