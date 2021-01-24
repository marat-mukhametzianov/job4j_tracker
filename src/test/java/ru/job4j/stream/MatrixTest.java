package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void convert() {
        int[][] matrix = {
                {1, 2},
                {10, 20}
        };
        assertThat(
                new Matrix().convert(matrix), is(List.of(1, 2, 10, 20))
        );
    }
}