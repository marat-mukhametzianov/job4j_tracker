package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueTextTest {

    @Test
    public void isEqualsTrue() {
        String initial = "My cat eats mice and drinks milk";
        String second = "My cat drinks milk and eats mice";
        assertThat(UniqueText.isEquals(initial, second), is(true));
    }

    @Test
    public void isEqualsFalse() {
        String initial = "My cat eats mice and drinks milk";
        String second = "Milk and mice have been eaten by my cat";
        assertThat(UniqueText.isEquals(initial, second), is(false));
    }
}