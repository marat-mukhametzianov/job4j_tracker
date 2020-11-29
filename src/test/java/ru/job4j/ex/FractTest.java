package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FractTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenNegative() {
        Fract.calc(-1);
    }

    @Test
    public void whenNought() {
        assertThat(Fract.calc(0), is(1));
    }

    @Test
    public void whenPositive() {
        assertThat(Fract.calc(3), is(6));
    }
}