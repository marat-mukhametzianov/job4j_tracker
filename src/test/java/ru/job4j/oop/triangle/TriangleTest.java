package ru.job4j.oop.triangle;

import junit.framework.TestCase;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TriangleTest extends TestCase {

    @Test
    public void testArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(4, 0);
        Triangle triangle = new Triangle(a, b, c);
        double expected = 6;
        double result = triangle.area();
        assertThat(expected, is(result));
    }
}