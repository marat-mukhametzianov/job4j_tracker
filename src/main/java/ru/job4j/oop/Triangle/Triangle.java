package ru.job4j.oop.Triangle;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double abLength;
    private double acLength;
    private double bcLength;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.abLength = a.distance(b);
        this.acLength = a.distance(c);
        this.bcLength = b.distance(c);
    }

    public boolean exists(double ab, double ac, double bc) {
        return (ab + ac) > bc && (ab + bc) > ac && (ac + bc) > ab;
    }

    public double halfPerimeter() {
        return (this.abLength + this.acLength + this.bcLength)/2;
    }

    public double area() {
        double result = -1;
        if (this.exists(this.abLength, this.acLength, this.bcLength)) {
            double perimeter = this.halfPerimeter();
            result = Math.sqrt(perimeter * (perimeter - this.abLength) * (perimeter - this.acLength) * (perimeter - this.bcLength));
        }
        return result;
    }
}
