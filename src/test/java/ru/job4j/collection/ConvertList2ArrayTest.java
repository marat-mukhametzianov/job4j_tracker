package ru.job4j.collection;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertList2ArrayTest {

    @Test
    public void toArray() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        ConvertList2Array convertList2Array = new ConvertList2Array();
        int[][] result = convertList2Array.toArray(list, 3);
        int[][] expected = {
            {1, 2, 3,},
            {4, 5, 6,},
            {7, 0, 0}
        };
        assertThat(result, is(expected));
    }
}