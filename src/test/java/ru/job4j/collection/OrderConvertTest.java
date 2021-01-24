package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class OrderConvertTest {

    @Test
    public void process() {
        OrderConvert converter = new OrderConvert();
        List<Order> orders = List.of(new Order("one", "1"), new Order("two", "2"));
        HashMap<String, Order> result = converter.process(orders);
        HashMap<String, Order> expected = new HashMap<String, Order>();
        expected.put("1", new Order("one", "1"));
        expected.put("2", new Order("two", "2"));
        assertEquals(expected, result);
    }
}