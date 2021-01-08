package ru.job4j.oop.triangle;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point another) {
        return sqrt(pow(this.x - another.x, 2) + pow(this.y - another.y, 2));
    }
}
