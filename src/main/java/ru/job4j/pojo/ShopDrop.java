package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        if (index == 0) {
            return products;
        }
        for (int i = index; i < products.length; i++) {
            products[i - 1] = products[i];
            products[i] = null;
        }
        return products;
    }
}
