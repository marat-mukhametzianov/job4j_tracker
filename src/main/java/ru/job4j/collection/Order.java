package ru.job4j.collection;

import java.util.Objects;

public class Order {
    private String name;
    private String number;

    public Order(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number = " + number + System.lineSeparator() +
                "name = " + name + System.lineSeparator() +
                "}";
    }

    @Override
    public boolean equals(Object object) {
        if ((object == null) || (object.getClass() != this.getClass())) return false;
        if (this == object) return true;
        Order order = (Order) object;
        return this.name.equals(order.name) && this.number.equals(order.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
