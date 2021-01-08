package ru.job4j.oop.story;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.name("Roller");
        Hare hare = new Hare();
        hare.name("Honey-bunny");
        Wolf wolf = new Wolf();
        wolf.name("Wolfenstain");
        Fox fox = new Fox();
        fox.name("Foxy");
        wolf.tryEat(ball);
        fox.tryEat(ball);
        hare.tryEat(ball);
        ball.runAway(wolf, hare, fox);
    }
}
