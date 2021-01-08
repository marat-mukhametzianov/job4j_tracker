package ru.job4j.strategy;

public class Square implements IShape {
    @Override
    public String draw() {
        String s = System.lineSeparator();
        return  "-----" + s
                +
                "|   |" + s
                +
                "|___|";
    }

    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }

}
