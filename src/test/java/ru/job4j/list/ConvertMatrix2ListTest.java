package ru.job4j.list;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertMatrix2ListTest {

    @Test
    public void toList() {
        ConvertMatrix2List converter = new ConvertMatrix2List();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = converter.toList(array);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(expected, is(result));
    }
}