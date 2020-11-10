package ru.job4j.oop.inheritance.product;

public class Shop {
    public static void main(String[] args) {
        Product product = of("Oil", 100);
        System.out.println(product.label());
    }

    private static Product of(String name, int price) {
        return new Product(name, price);
    }
}
