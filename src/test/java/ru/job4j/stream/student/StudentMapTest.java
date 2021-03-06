package ru.job4j.stream.student;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentMapTest {

    @Test
    public void modify() {
        List<Student> students = List.of(
                new Student(10, "Smith"),
                new Student(20, "Fox"),
                new Student(30, "Tocci"),
                new Student(50, "Smith")
        );
        Map<Integer, Student> result = new StudentMap().modify(students);
        assertThat(result.get("Fox"), is(new Student(20, "Fox")));
        assertThat(result.size(), is(3));
    }

    @Test
    public void levelOfTest() {
        List<Student> initialList = List.of(
                new Student(10, "Ten"),
                new Student(100, "Hundred")
        );
        List<Student> result = StudentLevel.levelOf(initialList, 50);
        assertThat(result.get(0), is(new Student(100, "Hundred")));
    }
}