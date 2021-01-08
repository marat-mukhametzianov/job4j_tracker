package ru.job4j.strategy;

import java.awt.*;

public class Paint {
    public void draw(IShape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}
