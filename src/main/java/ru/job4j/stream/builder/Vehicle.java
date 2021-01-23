package ru.job4j.stream.builder;

public class Vehicle {
    private int wheels;
    private int doors;
    private int seats;
    private String title;
    private String brand;
    private boolean ready;

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", doors=" + doors +
                ", seats=" + seats +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", ready=" + ready +
                '}';
    }

    static class Builder{
        private int wheels;
        private int doors;
        private int seats;
        private String title;
        private String brand;
        private boolean ready;

        Builder buildWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        Builder buildDoors(int doors) {
            this.doors = doors;
            return this;
        }

        Builder buildSeats(int seats) {
            this.seats = seats;
            return this;
        }

        Builder buidlTitle(String title) {
            this.title = title;
            return this;
        }

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildReady(boolean ready) {
            this.ready = ready;
            return this;
        }

        Vehicle build() {
            Vehicle vehicle = new Vehicle();
            vehicle.wheels = wheels;
            vehicle.doors = doors;
            vehicle.seats = seats;
            vehicle.title = title;
            vehicle.brand = brand;
            vehicle.ready = ready;
            return vehicle;
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle.Builder()
                .buildWheels(4)
                .buildDoors(4)
                .buildSeats(5)
                .buidlTitle("Lada")
                .buildBrand("VAZ")
                .buildReady(false)
                .build();
        System.out.println(vehicle);
    }
}
