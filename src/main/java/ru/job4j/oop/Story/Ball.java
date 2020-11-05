package ru.job4j.oop.Story;

public class Ball {
    private String name;

    public void Name(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void runAway(Wolf wolf, Hare hare, Fox fox) {
        System.out.println(wolf.getName() + ", " + fox.getName() + ", and " + hare.getName() + " tried to eat me, but I run away from them!");
    }
}
