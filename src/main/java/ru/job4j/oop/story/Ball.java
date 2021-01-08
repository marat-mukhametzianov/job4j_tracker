package ru.job4j.oop.story;

public class Ball {
    private String name;

    public void name(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void runAway(Wolf wolf, Hare hare, Fox fox) {
        System.out.println(wolf.getName() + ", " + fox.getName() + ", and "
                + hare.getName() + " tried to eat me, but I run away from them!");
    }
}
