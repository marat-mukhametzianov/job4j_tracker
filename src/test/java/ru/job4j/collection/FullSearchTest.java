package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {
    @Test
    public void extractNumber() {
        List<Task> initialList = List.of(
                new Task("1", "One"),
                new Task("2", "Two"),
                new Task("1", "False"));
        HashSet<String> expected = new HashSet<>(List.of("1", "2"));
        assertThat(expected, is(FullSearch.extractNumber(initialList)));
    }
}