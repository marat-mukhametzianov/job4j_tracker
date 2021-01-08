package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingleTest {
    @Test
    public void whenCreateSingletoneOne() {
        TrackerSingleOne one = TrackerSingleOne.INSTANCE;
        TrackerSingleOne two = TrackerSingleOne.INSTANCE;
        assertSame(one, two);
    }

    @Test
    public void whenCreateSingletoneTwo() {
        TrackerSingleTwo one = TrackerSingleTwo.getInstance();
        TrackerSingleTwo two = TrackerSingleTwo.getInstance();
        assertSame(one, two);
    }

    @Test
    public void whenCreateSingletoneThree() {
        TrackerSingleThree one = TrackerSingleThree.getINSTANCE();
        TrackerSingleThree two = TrackerSingleThree.getINSTANCE();
        assertSame(one, two);
    }

    @Test
    public void whenCreateSingletoneFour() {
        TrackerSingleFour one = TrackerSingleFour.getInstance();
        TrackerSingleFour two = TrackerSingleFour.getInstance();
        assertSame(one, two);
    }
}