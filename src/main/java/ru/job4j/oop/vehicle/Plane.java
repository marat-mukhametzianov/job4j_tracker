package ru.job4j.oop.vehicle;

public class Plane implements IVehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " is flying.");
    }
}
