package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> vehicles = new HashSet<>();
        vehicles.add("Lada");
        vehicles.add("BMW");
        vehicles.add("Volvo");
        vehicles.add("Toyota");
        for (String vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
