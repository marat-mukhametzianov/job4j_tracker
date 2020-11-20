package ru.job4j.oop;

public class HierarchyUsing {
    public static void main(String[] args) {
        Car car = new Car();
        Vehicle vehicle = car;
        Object object = car;
        Object ocar = new Car();
        Car carFromObject = (Car) ocar;
        Object bicycle = new Bicycle();
        Car cb = (Car) bicycle;
    }
}
