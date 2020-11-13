package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void thirdNull() {
        Product[] products = new Product[5];
        products[0] = new Product("Nought", 0);
        products[1] = new Product("One", 1);
        products[2] = new Product("Two", 2);
        int expected = 3;
        int out = Shop.indexOfNull(products);
        assertThat(out, is(expected));
    }

    @Test
    public void lastNull() {
        Product[] products = new Product[4];
        products[0] = new Product("Nought", 0);
        products[1] = new Product("One", 1);
        products[2] = new Product("Two", 2);
        int expected = 3;
        int out = Shop.indexOfNull(products);
        assertThat(out, is(expected));
    }

    @Test
    public void firstNull() {
        Product[] products = new Product[3];
        products[1] = new Product("One", 1);
        products[2] = new Product("Two", 2);
        int expected = 0;
        int out = Shop.indexOfNull(products);
        assertThat(out, is(expected));
    }
}