package ru.job4j.oop.vehicle;

public class Index {
    public static void main(String[] args) {
        IVehicle plane = new Plane();
        IVehicle train = new Train();
        IVehicle bus = new Bus();
        IVehicle[] vehicles = {plane, train, bus};
        for (IVehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
