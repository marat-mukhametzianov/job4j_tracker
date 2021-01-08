package ru.job4j.oop.animals;

public class DomesticAnimal extends Animal {
    public void liveOnFarm() {
        System.out.println(new Animal().getNameClass() + " живет на ферме, приносит пользу.");
    }
}
