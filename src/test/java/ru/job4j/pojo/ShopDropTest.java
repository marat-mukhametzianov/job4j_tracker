package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShopDropTest {

    @Test
    public void whenDropFirst() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] result = ShopDrop.leftShift(products, 0);
        assertThat(result[0].getName(), is("Milk"));
        assertThat(result[1].getName(), is("Bread"));
    }

    @Test
    public void whenDropLast() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] result = ShopDrop.leftShift(products, 1);
        assertThat(result[0].getName(), is("Bread"));
        assertThat(result[1], is(nullValue()));
    }
}