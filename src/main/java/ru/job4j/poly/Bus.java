package ru.job4j.poly;

public class Bus implements Vehicle {
    public void drive() {
        System.out.println("The bus's going");
    }

    public void passengers(byte quantity) {
        if (quantity != 0) {
            System.out.println("The bus has passengers");
        }
    }

    public double cost(double gas) {
        return gas * 3.259;
    }
}
