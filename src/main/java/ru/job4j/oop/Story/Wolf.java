package ru.job4j.oop.Story;

public class Wolf {
    private String name;

    public void Name(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void tryEat(Ball ball) {
        System.out.println(this.name + " tried to eat " + ball.getName() + ".");
    }
}
