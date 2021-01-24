package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {

    @Test
    public void convert() {
        ConvertList converter = new ConvertList();
        List<int[]> initialList = new ArrayList<>();
        initialList.add(new int[] {1});
        initialList.add(new int[] {2, 3});
        List<Integer> result = List.of(1, 2, 3);
        assertThat(result, is(converter.convert(initialList)));
    }
}