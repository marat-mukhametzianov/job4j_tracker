package ru.job4j.oop.animals;

public class Cow extends DomesticAnimal {
    public void giveMilk() {
        System.out.println(new Animal().getNameClass() + " дает человеку молоко.");
    }
}
