package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.departments.Departments;
import ru.job4j.collection.departments.DescComparator;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expected = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCorrect() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void ascSorting() {
        List<String> input = Arrays.asList("k2/sk3/ssk1", "k2", "k1", "k2/sk1", "k1/sk1/ssk1");
        Departments.sortAsc(Departments.fillGaps(input));
    }

    @Test
    public void descSorting() {
        List<String> input = Arrays.asList("k2/sk3/ssk1", "k2", "k1", "k2/sk1", "k1/sk1/ssk1");
        Departments.sortDesc(Departments.fillGaps(input));
    }

    @Test
    public void descComporatorEqualFirstPartsDifferentLast() {
        assertThat(new DescComparator().compare("k1/sk1/ssk2", "k1/sk1/ssk1"), greaterThan(0));
    }

    @Test
    public void descComporatorDifferentFirstParts() {
        assertThat(new DescComparator().compare("k2/sk1/ssk1", "k1/sk1/ssk1"), lessThan(0));
    }
}