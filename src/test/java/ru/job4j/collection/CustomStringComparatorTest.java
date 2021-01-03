package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomStringComparatorTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenNullGenerateException() {
        String left = null;
        String right = "a";
        new CustomStringComparator().compare(left, right);
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenEmptyGenerateException() {
        String left = "";
        String right = "a";
        new CustomStringComparator().compare(left, right);
    }

    @Test
    public void whenStringsAreEqualThenNought() {
        assertThat(new CustomStringComparator().compare("abc", "abc"), is(0));
    }

    @Test
    public void whenFirstLessThanSecondThenBelowNought() {
        assertThat(new CustomStringComparator().compare("Ab", "ab"), lessThan(0));
    }

    @Test
    public void whenFirstGreaterThanAboveNought() {
        assertThat(new CustomStringComparator().compare("ab", "Ab"), greaterThan(0));
    }

    @Test
    public void whenFirstStringIsASubstringOfTheSecondOneThanBelowNought() {
        assertThat(new CustomStringComparator().compare("ab", "abc"), lessThan(0));
    }

    @Test
    public void whenSecondStringIsASubstringOfTheFirstOneThanAboveNought() {
        assertThat(new CustomStringComparator().compare("abc", "ab"), greaterThan(0));
    }
}