package ru.job4j.strategy;

public class Triangle implements IShape {
    @Override
    public String draw() {
        String s = System.lineSeparator();
        return "  ^  " + s +
               " /  \\" + s +
               "/____\\";
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().draw());
    }
}