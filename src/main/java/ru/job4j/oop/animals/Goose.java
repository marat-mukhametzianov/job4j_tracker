package ru.job4j.oop.animals;

public class Goose extends DomesticAnimal {
    public void bringFeather() {
        System.out.println(new Animal().getNameClass() + " приносит перо для подушек.");
    }
}
