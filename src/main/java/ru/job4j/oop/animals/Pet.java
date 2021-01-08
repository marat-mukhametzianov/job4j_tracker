package ru.job4j.oop.animals;

public class Pet extends Animal {
    public void vaccinate() {
        System.out.println(new Animal().getNameClass()
                + " нуждается в прививках, чтобы не болеть.");
    }
}
