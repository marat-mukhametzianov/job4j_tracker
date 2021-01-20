package ru.job4j.stream.student;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setup() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(40, "Surname4"));
        students.add(new Student(50, "Surname5"));
        students.add(new Student(60, "Surname6"));
        students.add(new Student(70, "Surname7"));
        students.add(new Student(80, "Surname8"));
        students.add(new Student(90, "Surname9"));
    }

    @Test
    public void whenCollectClassA() {
        Predicate<Student> rule1 = student -> student.getScore() >= 70;
        Predicate<Student> rule2 = student -> student.getScore() <= 100;
        Predicate<Student> compoundRule = rule1.and(rule2);
        School school = new School();
        List<Student> result = school.collect(students, compoundRule);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(80, "Surname8"));
        expected.add(new Student(90, "Surname9"));
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        Predicate<Student> rule1 = student -> student.getScore() >= 50;
        Predicate<Student> rule2 = student -> student.getScore() < 70;
        Predicate<Student> compoundRule = rule1.and(rule2);
        School school = new School();
        List<Student> result = school.collect(students, compoundRule);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        Predicate<Student> rule1 = student -> student.getScore() > 0;
        Predicate<Student> rule2 = student -> student.getScore() < 50;
        Predicate<Student> compoundRule = rule1.and(rule2);
        School school = new School();
        List<Student> result = school.collect(students, compoundRule);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(20, "Surname2"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(result, is(expected));
    }
}