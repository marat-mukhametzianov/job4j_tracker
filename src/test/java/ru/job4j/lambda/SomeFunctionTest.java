package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SomeFunctionTest {

    @Test
    public void linearMXPlusB() {
        List<Double> result = new SomeFunction().range(5, 7, value -> 2 * value + 5);
        assertThat(result, is(List.of(15D, 17D, 19D)));
    }

    @Test
    public void quadraticMX2PlusB() {
        List<Double> result = new SomeFunction().range(2, 4, value -> 2 * Math.pow(value, 2) + 5);
        assertThat(result, is(List.of(13D, 23D, 37D)));
    }

    @Test
    public void exponentialAPowX() {
        List<Double> result = new SomeFunction().range(2, 3, value -> Math.pow(3, value));
        assertThat(result, is(List.of(9D, 27D)));
    }
}