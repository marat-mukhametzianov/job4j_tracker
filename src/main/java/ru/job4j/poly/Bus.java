package ru.job4j.poly;

public class Bus implements Vehicle {
    public void Drive() {
        System.out.println("The bus's going");
    }

    public void Passengers(byte quantity) {
        if (quantity != 0) {
            System.out.println("The bus has passengers");
        }
    }

    public double Cost(double gas) {
        return gas * 3.259;
    }
}
