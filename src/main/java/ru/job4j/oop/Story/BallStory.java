package ru.job4j.oop.Story;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.Name("Roller");
        Hare hare = new Hare();
        hare.Name("Honey-bunny");
        Wolf wolf = new Wolf();
        wolf.Name("Wolfenstain");
        Fox fox = new Fox();
        fox.Name("Foxy");
        wolf.tryEat(ball);
        fox.tryEat(ball);
        hare.tryEat(ball);
        ball.runAway(wolf, hare, fox);
    }
}
