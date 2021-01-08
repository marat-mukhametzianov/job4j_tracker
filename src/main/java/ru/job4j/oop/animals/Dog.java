package ru.job4j.oop.animals;

public class Dog extends Pet {
    public void runAfterCat() {
        System.out.println(new Animal().getNameClass()
                + " не любит кошек, постоянно за ними гоняется.");
    }
}
