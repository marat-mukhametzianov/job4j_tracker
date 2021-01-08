package ru.job4j.oop.story;

public class Wolf {
    private String name;

    public void name(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void tryEat(Ball ball) {
        System.out.println(this.name + " tried to eat " + ball.getName() + ".");
    }
}
